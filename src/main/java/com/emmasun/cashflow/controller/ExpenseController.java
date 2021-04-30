package com.emmasun.cashflow.controller;

import com.emmasun.cashflow.exception.ExpenseNotFoundException;
import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense theExpense){
        expenseService.saveExpense(theExpense);
        return theExpense;
    }

    @PutMapping("/expenses")
    public Expense updateExpense(@RequestBody Expense theExpense){
        expenseService.saveExpense(theExpense);
        return theExpense;
    }

    @DeleteMapping("/expenses/{expenseId}")
    public String deleteExpense(@PathVariable int expenseId){
        Optional<Expense> expense = expenseService.getExpenseById(expenseId);
        if(!expense.isPresent())
            throw new ExpenseNotFoundException("expense not found with id " + expenseId);
        expenseService.deleteExpense(expenseId);
        return String.format("Expense %d deleted successfully", expenseId);
    }
}
