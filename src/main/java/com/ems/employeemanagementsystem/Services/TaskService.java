package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Endpoints.Tasks;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;

import java.util.List;

public interface TaskService {
    Tasks createTask (TaskRequest taskRequest) throws Exception;
    List<Tasks> getAllTasks ();
    Tasks getTasksById (long id);
    List<Tasks> getTasksByUser (Users user);
}
