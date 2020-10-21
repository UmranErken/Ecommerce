package com.example.ecommercemubuto.service.api;

import com.example.ecommercemubuto.service.api.request.LoginRequest;
import com.example.ecommercemubuto.service.api.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MubutoApi {
    String BASE_URL = "http://10.107.15.210/ApiExample/";

    @POST("token")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}

