package com.example.ecommercemubuto.helper.exception;

public class KeyNotFoundException extends Exception {

    public KeyNotFoundException() {
        super("key not found");
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
