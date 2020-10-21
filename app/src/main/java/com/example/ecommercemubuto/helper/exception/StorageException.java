package com.example.ecommercemubuto.helper.exception;

public class StorageException extends Exception {

    public StorageException() {
        super("storage exception");
    }

    public StorageException(String message) {
        super(message);
    }
}