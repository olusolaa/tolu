package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;

import java.util.List;

public interface ExpenseService {
    List<Expense> getExpenseById(Employee employee);
    List<Expense> getExpenseById(Admin admin);
    List<Expense> getAllExpense();
    Expense createExpense(ExpenseRequest expenseRequest);

}
