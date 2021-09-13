package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ExpenseService {
    ResponseApi createExpense(ExpenseRequest expenseRequest, HttpServletRequest request) throws Exception;
    List<Expense> listAllExpense();
    Expense getExpenseById(Long id);
    List<Expense> getExpenseByUsers(Users users);
//    List<Expense> getExpenseById(Employee employee);
//    List<Expense> getExpenseById(Admin admin);
}
