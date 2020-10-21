package com.example.ecommercemubuto.helper.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ecommercemubuto.helper.exception.KeyNotFoundException;
import com.example.ecommercemubuto.helper.tools.Crypto;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Storage {

    private boolean isSecure;
    private SharedPreferences sharedPreferences;

    public Storage(boolean isSecure, String preferenceName, Context context) {
        this.isSecure = isSecure;
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    public <T> void insert(String key, T value)
            throws NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String serializedData = new Gson().toJson(value);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.contains(key)) {
            editor.remove(key);
        }
        if (isSecure) {
            try {
                String encryptedData = Crypto.encryptToString(serializedData);
                editor.putString(key, encryptedData);
            } catch (Exception e) {
                Log.d("DEBUG", "insert: " + e.getMessage());
                throw e;
            } finally {
                editor.commit();
            }
            return;
        }
        editor.putString(key, serializedData);
        editor.commit();
    }

    public boolean exists(String key) {
        return sharedPreferences.contains(key);
    }

    public void delete(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
    }

    public <T> T get(String key, Class<T> type)
            throws NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, KeyNotFoundException {
        if (!sharedPreferences.contains(key)) {
            throw new KeyNotFoundException("key:" + key + " not found");
        }
        String data = sharedPreferences.getString(key, null);
        if (data == null) {
            return null;
        }
        String serializedData = data;
        if (isSecure) {
            try {
                serializedData = Crypto.decrypt(data);
            } catch (Exception e) {
                Log.d("DEBUG", "get: " + e.getMessage());
                throw e;
            }
        }
        return new Gson().fromJson(serializedData, type);
    }
}