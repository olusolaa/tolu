package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.PayrollRepository;
import com.ems.employeemanagementsystem.Services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public Payroll getPayrollById(Long id) {
        return null;
    }

    @Override
    public List<Payroll> getAllPayroll() {
        return null;
    }

    @Override
    public Payroll createPayroll(Payroll payroll) {
        return null;
    }

    @Override
    public List<Payroll> getPayrollByUsers(Users users) {
        return null;
    }
}
