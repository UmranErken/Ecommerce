package com.example.ecommercemubuto.service.api.request;

import com.google.gson.annotations.SerializedName;

public class UpdatePushTokenRequest extends ServiceRequest {
    @SerializedName("pushtoken")
    private String pushToken;

    public UpdatePushTokenRequest(String pushtoken) {
        super();
        this.pushToken = pushtoken;
    }

    public String getPushToken() {
        return pushToken;
    }
}