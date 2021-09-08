package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
