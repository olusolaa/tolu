package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Task;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksEndPoints {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/all")
    public List<Task> getAllTasks () {
        List<Task> taskList = taskService.listAllTasks();
        return taskList;
    }

    @RequestMapping("/{id}")
    public Task getTasksById (@PathVariable(value = "id") Long tasksId ) {
        return this.taskService.getTasksById(tasksId);
    }

    @RequestMapping("/users/{id}")
    public List<Task> getTasksByUser(@PathVariable Long id) {
        var users = userRepository.findById(id).get();
        return this.taskService.getTasksByUser(users);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createTasks (@RequestBody TaskRequest taskRequest, @PathVariable Long id) throws Exception {
        ResponseApi responseApi=  taskService.createTask(taskRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }




}
