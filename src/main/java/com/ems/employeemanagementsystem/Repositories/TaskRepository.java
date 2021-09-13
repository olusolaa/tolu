package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Task;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUsers(Users users);
    List<Task> findAllByUsers(Users users);
    Task findTaskByDescription(String description);
    Void deleteTaskByUsers(Users users);
}
