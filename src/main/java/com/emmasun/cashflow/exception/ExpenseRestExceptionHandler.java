package com.emmasun.cashflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpenseRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExpenseErrorResponse> handleException(ExpenseNotFoundException e) {
        ExpenseErrorResponse error = new ExpenseErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExpenseErrorResponse> handleException(Exception e) {
        ExpenseErrorResponse error = new ExpenseErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage("Something has gone wrong.");
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
