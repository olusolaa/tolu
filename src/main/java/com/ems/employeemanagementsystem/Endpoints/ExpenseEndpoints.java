package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseEndpoints {

    @Autowired
    private ExpenseServiceImpl expenseService;

    @RequestMapping("/all")
    public List<Expense> getAllTodos () {
        List<Expense> expenseList = expenseService.listAllExpense();
        return expenseList;
    }

    @RequestMapping("/{id}")
    public Expense getTodosById (@PathVariable(value = "id") Long expenseId ) {
        return this.expenseService.getExpenseById(expenseId);
    }

    @RequestMapping("/users-expense")
    public List<Expense> getTodosByUser(Users users) {
        return this.expenseService.getExpenseByUsers(users);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addTodos (@RequestBody ExpenseRequest expenseRequest) throws Exception {
        expenseService.createExpense(expenseRequest);
        return ResponseEntity.status(HttpStatus.OK).body(expenseRequest);
    }

}
