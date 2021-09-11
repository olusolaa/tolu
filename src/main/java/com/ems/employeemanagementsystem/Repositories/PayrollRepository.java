package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findAllByUsers(Users users);
}
