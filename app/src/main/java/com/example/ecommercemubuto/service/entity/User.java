package com.example.ecommercemubuto.service.entity;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("UserName")
    private String UserName;

    @SerializedName("Password")
    private String Password;
    @SerializedName("confirmPassword")
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }



}
