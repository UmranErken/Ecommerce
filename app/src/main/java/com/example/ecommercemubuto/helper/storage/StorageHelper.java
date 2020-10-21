package com.example.ecommercemubuto.helper.storage;

import android.content.Context;

import com.example.ecommercemubuto.helper.exception.StorageException;

public class StorageHelper {

    private static Context _context;
    private static Storage localStorage;
    private static Storage secureStorage;

    public static void initialize(Context context) {
        _context = context;
    }

    public static Storage getLocalStorage() throws StorageException {
        if (_context == null) {
            throw new StorageException("storage not initialized. call initialize() first");
        }
        if (localStorage == null) {
            localStorage = new Storage(false, "oblique_storage", _context);
        }
        return localStorage;
    }

    public static Storage getSecureStorage() throws StorageException {
        if (_context == null)
            throw new StorageException("storage not initialized. call initialize() first");
        if (secureStorage == null) {
            secureStorage = new Storage(true, "oblique_storage", _context);
        }
        return secureStorage;
    }
}