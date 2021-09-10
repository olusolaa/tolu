package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.ExpenseRepository;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(ExpenseRequest expenseRequest) throws Exception {
        Expense expense = new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setDescription(expenseRequest.getDescription());
        expense.setTitle(expenseRequest.getTitle());

        return null;
    }

    //for admin
    @Override
    public List<Expense> listAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(@PathVariable(value = "id") Long expenseId) {
        return this.expenseRepository.findById(expenseId).
                orElseThrow(()-> new ResourceNotFoundException("Todo with ID" + expenseId +" not found"));
    }

    @Override
    public List<Expense> getExpenseByUsers(Users users) {
        return expenseRepository.findExpenseByUsers(users);
    }
}
