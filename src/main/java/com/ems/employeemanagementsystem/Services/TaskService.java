package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Endpoints.TasksEndPoints;
import com.ems.employeemanagementsystem.Models.Task;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import java.util.List;

public interface TaskService {
    ResponseApi createTask (TaskRequest taskRequest, Long id) throws Exception;
    List<Task> listAllTasks ();
    Task getTasksById (Long id);
    List<Task> getTasksByUser (Users user);
}