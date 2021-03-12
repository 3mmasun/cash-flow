package com.emmasun.cashflow.service;

import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public Iterable<Expense> getExpenses(){
        return expenseRepository.findAll();
    };

    public Optional<Expense> getExpenseById(int expenseId) {
        return expenseRepository.findById(expenseId);
    }
}
