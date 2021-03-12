package com.emmasun.cashflow.exception;

import org.springframework.http.HttpStatus;

public class ExpenseErrorResponse {
    private HttpStatus status;
    private String message;
    private long timestamp;

    public ExpenseErrorResponse() {
    }

    public ExpenseErrorResponse(HttpStatus status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
