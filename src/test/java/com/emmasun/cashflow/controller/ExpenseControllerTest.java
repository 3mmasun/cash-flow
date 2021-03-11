package com.emmasun.cashflow.controller;

import com.emmasun.cashflow.entity.Expense;
import com.emmasun.cashflow.service.ExpenseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseControllerTest {

    @Mock
    ExpenseService expenseService;

    @Test
    public void shouldReturnStatus200_whenGetExpensesRequest() throws JSONException, JsonProcessingException {
        List<Expense> expenses = Collections.singletonList(new Expense("meal", "changi", 51.0f));
        Mockito.when(expenseService.getExpenses()).thenReturn(expenses);
        ExpenseController expenseController = new ExpenseController(expenseService);

        ResponseEntity<Iterable<Expense>> result = expenseController.getExpenses();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expenses);
    }

}