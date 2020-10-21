package com.example.ecommercemubuto.helper.exception;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("authentication failure");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
