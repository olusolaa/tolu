package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findExpenseByUsers(Users users);
    Expense findAllById(Long id);
    Expense findExpenseByAmount(Long amount);
    Void deleteByUsers(Users users);
}
