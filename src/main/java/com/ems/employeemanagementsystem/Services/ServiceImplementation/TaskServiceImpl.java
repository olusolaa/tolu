package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Endpoints.TasksEndPoints;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.TaskRepository;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;
import com.ems.employeemanagementsystem.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TasksEndPoints createTask(TaskRequest taskRequest) throws Exception {
        return null;
    }

    @Override
    public List<TasksEndPoints> getAllTasks() {
        return null;
    }

    @Override
    public TasksEndPoints getTasksById(long id) {
        return null;
    }

    @Override
    public List<TasksEndPoints> getTasksByUser(Users user) {
        return null;
    }
}
