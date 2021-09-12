package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Task;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.TaskRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUsers(Users users);
    List<Task> findAllByUsers(Users users);
    Task findTaskByDescription(String description);
    Void deleteTaskByUsers(Users users);
}
