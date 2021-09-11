package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
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

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<Expense> getAllTodos () {
        List<Expense> expenseList = expenseService.listAllExpense();
        return expenseList;
    }

    @RequestMapping("/{id}")
    public Expense getExpenseById (@PathVariable(value = "id") Long expenseId ) {
        return this.expenseService.getExpenseById(expenseId);
    }

    @RequestMapping("/users/{id}")
    public List<Expense> getExpenseByUser(@PathVariable Long id) {
    Users users = userRepository.getById(id);
        return this.expenseService.getExpenseByUsers(users);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createExpense (@RequestBody ExpenseRequest expenseRequest, @PathVariable Long id) throws Exception {
      ResponseApi responseApi=  expenseService.createExpense(expenseRequest, id);
        System.out.println(responseApi.getData());
      return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

}
