package com.emmasun.cashflow.exception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public ExpenseNotFoundException(Throwable cause) {
        super(cause);
    }

    public ExpenseNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
