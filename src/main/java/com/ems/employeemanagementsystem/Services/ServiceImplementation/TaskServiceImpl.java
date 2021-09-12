package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Endpoints.TasksEndPoints;
import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Models.Task;
import com.ems.employeemanagementsystem.Models.TaskEnum;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.TaskRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.TaskService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseApi createTask(TaskRequest taskRequest, Long id) throws Exception {
        var users = userRepository.getById(id);
        var task = new Task();
        var response = new ResponseApi();

        task.setFirstName(users.getFirstName());
        task.setLastName(users.getLastName());
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setTaskEnum(TaskEnum.OPEN);
        task.setUsers(users);

        var taskDb= taskRepository.save(task);

        response.setMessage("Task tagged "+ taskRequest.getTitle() +" " +"has been assigned to "+
                " "+ users.getFirstName()+" "+ users.getLastName());
        response.setData(taskDb);
        return response;
    }

    @Override
    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTasksById(@PathVariable(value = "id") Long id) {
        return this.taskRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Task with ID" + id +" not found"));
    }

    @Override
    public List<Task> getTasksByUser(Users user) {
        return  taskRepository.findAllByUsers(user);
    }
}
