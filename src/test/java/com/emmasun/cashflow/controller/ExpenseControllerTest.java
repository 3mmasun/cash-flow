package com.emmasun.cashflow.controller;

import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.service.ExpenseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseControllerTest {

    @Mock
    ExpenseService expenseService;
    ExpenseController expenseController;

    @Before
    public void setUp(){
        expenseController = new ExpenseController(expenseService);
    }

    @Test
    public void shouldReturnAllExpense_givenGetExpensesRequest() {
        List<Expense> expenses = Collections.singletonList(new Expense("meal", "changi", 51.0f));
        Mockito.when(expenseService.getExpenses()).thenReturn(expenses);

        ResponseEntity<Iterable<Expense>> result = expenseController.getExpenses();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expenses);
    }

    @Test
    public void shouldReturnSingleExpense_whenExpenseIsFound(){
        Expense expense = new Expense("meal", "changi", 51.0f);
        Mockito.when(expenseService.getExpenseById(1)).thenReturn(Optional.of(expense));

        Expense result = expenseController.getExpense(1);

        assertThat(result).isEqualTo(expense);
    }

}