package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Repositories.ExpenseRepository;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenseById(Employee employee) {
        return null;
    }

    @Override
    public List<Expense> getExpenseById(Admin admin) {
        return null;
    }

    @Override
    public List<Expense> getAllExpense() {
        return null;
    }

    @Override
    public Expense createExpense(ExpenseRequest expenseRequest) {
        return null;
    }
}