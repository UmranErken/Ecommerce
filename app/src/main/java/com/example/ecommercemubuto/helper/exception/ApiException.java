package com.example.ecommercemubuto.helper.exception;

public class ApiException extends Exception {
    public ApiException() {
        super("api failure");
    }

    public ApiException(String message) {
        super(message);
    }
}
