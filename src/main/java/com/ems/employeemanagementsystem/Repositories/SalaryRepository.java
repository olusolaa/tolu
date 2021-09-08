package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Salary;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Salary findSalaryByAmount(Long amount);
    Salary findSalaryByUsers(Users users);
    Salary deleteSalariesByUsers(Users users);


}
