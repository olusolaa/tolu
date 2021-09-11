package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Models.Admin;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.ExpenseRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseApi createExpense(ExpenseRequest expenseRequest, Long id) throws Exception {
        Users users = userRepository.getById(id);

        Expense expense = new Expense();
        ResponseApi response = new ResponseApi();
        if (expenseRequest.getAmount()<=0) {
            response.setMessage("Invalid figure");
            return response;
        }
            expense.setDescription(expenseRequest.getDescription());
            expense.setTitle(expenseRequest.getTitle());
            expense.setAmount(expenseRequest.getAmount());
            expense.setFirstName(users.getFirstName());
            expense.setLastName(users.getLastName());
            expense.setUsers(users);

           Expense expensedb = expenseRepository.save(expense);
        response.setMessage("The record of your Expense has been created successfully");
        response.setData(expensedb);
        return response;
    }

    //for admin
    @Override
    public List<Expense> listAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(@PathVariable(value = "id") Long expenseId) {
        return this.expenseRepository.findById(expenseId).
                orElseThrow(()-> new ResourceNotFoundException("Expense with ID" + expenseId +" not found"));
    }

    @Override
    public List<Expense> getExpenseByUsers(Users users) {
        return expenseRepository.findAllByUsers(users);
    }
}
