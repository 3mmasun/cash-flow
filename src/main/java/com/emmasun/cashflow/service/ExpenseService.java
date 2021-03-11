package com.emmasun.cashflow.service;

import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public Iterable<Expense> getExpenses(){
        return expenseRepository.findAll();
    };
}
