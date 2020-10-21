package com.example.ecommercemubuto.service.api;

import com.example.ecommercemubuto.helper.storage.StorageHelper;
import com.example.ecommercemubuto.service.api.request.LoginRequest;
import com.example.ecommercemubuto.service.api.response.LoginResponse;

import java.io.IOException;

import retrofit2.Call;

public class UserService extends ServiceBase {

    public void loginAsync( final String username, final String password, final String grantType, final MubutoCallBack<LoginResponse> callback) {


        try {
            Call<LoginResponse> call = getMubutoApi().login(new LoginRequest(username, password,grantType));
            super.getAsync(call, new MubutoCallBack<LoginResponse>() {


                @Override
                public void onSuccess(Call<LoginResponse> call, LoginResponse response) {
                    saveTokenResult(response, username, password);
                    callback.onSuccess(call, response);
                }

                private void saveTokenResult(LoginResponse response, String username, String password) {
                    try {
                        StorageHelper.getSecureStorage().insert("token", response.getToken());
                        StorageHelper.getSecureStorage().insert("username", username);
                        StorageHelper.getSecureStorage().insert("password", password);
                    } catch (Exception e) {
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    callback.onFailure(call, t);
                }

                @Override
                public void onAuthenticationFailure(String message) {
                    callback.onAuthenticationFailure(message);
                }

                @Override
                public void onError(int errorCode, Boolean status, String message) {
                    callback.onError(errorCode, status, message);
                }
            });
        }
        catch (Exception e){
            System.out.println(e);
        }

}

    public LoginResponse login(String username, String password, String grantType) throws IOException, AuthenticationException,ApiException{
        Call<LoginResponse> call = getMubutoApi().login(new LoginRequest(username, password,grantType));
        LoginResponse response = super.get(call);
        this.saveTokenResult(response,username, password);
        return response;
    }


    private void saveTokenResult(LoginResponse response, String username, String password) {
        try {
            StorageHelper.getSecureStorage().insert("token", response.getToken());
            StorageHelper.getSecureStorage().insert("username", username);
            StorageHelper.getSecureStorage().insert("password", password);

        } catch (Exception e) {
        }
    }



}