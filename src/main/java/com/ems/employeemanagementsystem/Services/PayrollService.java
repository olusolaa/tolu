package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.PayrollRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import java.util.List;

public interface PayrollService {
    ResponseApi createPayrollRecord(PayrollRequest payrollRequest, Long id) throws Exception;
    List<Payroll> listAllPayroll();
    Payroll getPayrollById(Long id);
    List<Payroll> getPayrollByUsers(Users users);
}
