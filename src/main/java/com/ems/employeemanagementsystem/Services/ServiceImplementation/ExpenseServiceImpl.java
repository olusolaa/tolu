package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.Services.ExpenseService;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

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
