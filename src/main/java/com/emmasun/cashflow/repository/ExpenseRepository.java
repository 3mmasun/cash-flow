package com.emmasun.cashflow.repository;

import com.emmasun.cashflow.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

}
