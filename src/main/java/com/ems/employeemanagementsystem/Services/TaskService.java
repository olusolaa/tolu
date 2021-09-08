package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Endpoints.TasksEndPoints;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;

import java.util.List;

public interface TaskService {
    TasksEndPoints createTask (TaskRequest taskRequest) throws Exception;
    List<TasksEndPoints> getAllTasks ();
    TasksEndPoints getTasksById (long id);
    List<TasksEndPoints> getTasksByUser (Users user);
}
