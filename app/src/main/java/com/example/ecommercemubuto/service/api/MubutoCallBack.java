package com.example.ecommercemubuto.service.api;

import retrofit2.Call;

public interface MubutoCallBack<T> {
    void onSuccess(Call<T> call, T response);

    void onFailure(Call<T> call, Throwable t);

    void onAuthenticationFailure(String message);

    void onError(int errorCode, Boolean status, String message);
}
