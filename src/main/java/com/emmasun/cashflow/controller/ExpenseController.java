package com.emmasun.cashflow.controller;

import com.emmasun.cashflow.exception.ExpenseNotFoundException;
import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(@Autowired ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public ResponseEntity<Iterable<Expense>> getExpenses(){
        return ResponseEntity
                .ok(expenseService.getExpenses());
    }

    @GetMapping("/expenses/{expenseId}")
    public Expense getExpense(@PathVariable int expenseId) {
        Optional<Expense> expense = expenseService.getExpenseById(expenseId);
        if(!expense.isPresent())
            throw new ExpenseNotFoundException("expense not found with id " + expenseId);
        return expense.get();
    }
}
