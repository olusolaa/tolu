package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;

import java.util.List;

public interface PayrollService {
    Payroll getPayrollById(Long id);
    List<Payroll> getAllPayroll();
    Payroll createPayroll(Payroll payroll);
    List<Payroll> getPayrollByUsers(Users users);
}
