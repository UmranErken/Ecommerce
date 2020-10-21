package com.example.ecommercemubuto.service.api.request;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;
    @SerializedName("grant_type")
    private String grantType;



    public LoginRequest(String username, String password,String grantType) {
        this.username = username;
        this.password = password;
        this.grantType = grantType;

    }
}
