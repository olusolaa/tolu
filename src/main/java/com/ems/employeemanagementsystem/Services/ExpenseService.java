package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import java.util.List;

public interface ExpenseService {
    ResponseApi createExpense(ExpenseRequest expenseRequest) throws Exception;
    List<Expense> listAllExpense();
    Expense getExpenseById(Long id);
    List<Expense> getExpenseByUsers(Users users);
//    List<Expense> getExpenseById(Employee employee);
//    List<Expense> getExpenseById(Admin admin);
}
