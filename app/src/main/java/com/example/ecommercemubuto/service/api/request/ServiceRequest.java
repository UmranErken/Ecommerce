package com.example.ecommercemubuto.service.api.request;

import com.example.ecommercemubuto.helper.storage.StorageHelper;
import com.google.gson.annotations.SerializedName;

public class ServiceRequest {

    @SerializedName("access_token")
    private String token;

    public ServiceRequest() {
        try {
            this.token = StorageHelper.getSecureStorage().get("token", String.class);
        } catch (Exception e) {
            this.token = "";
        }
    }

    public ServiceRequest(String token) {
        try {
            this.token = token;
        } catch (Exception e) {
            this.token = "";
        }
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
