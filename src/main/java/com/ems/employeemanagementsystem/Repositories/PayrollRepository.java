package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Payroll findPayrollBy(String email, String password);
    Payroll findPayrollByFirstName(String firstName);
    Payroll findPayrollByLastName(String lastName);
    Optional<Users> deleteById();
}
