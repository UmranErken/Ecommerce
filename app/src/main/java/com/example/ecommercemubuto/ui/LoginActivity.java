package com.example.ecommercemubuto.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ecommercemubuto.MainActivity;
import com.example.ecommercemubuto.MubutoFirebaseMessagingService;
import com.example.ecommercemubuto.R;
import com.example.ecommercemubuto.service.api.MubutoCallBack;
import com.example.ecommercemubuto.service.api.ServiceBase;
import com.example.ecommercemubuto.service.api.UserService;
import com.example.ecommercemubuto.service.api.response.LoginResponse;
import com.kaopiz.kprogresshud.KProgressHUD;

import retrofit2.Call;


public class LoginActivity extends AppCompatActivity {

    private UserService userService;
    private KProgressHUD hud;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        ServiceBase.setApplicationContext(LoginActivity.this);
        if (userService == null) {
            userService = new UserService();
        }

        final EditText edtUserName = (EditText) findViewById(R.id.username);
        final EditText edtPassword = (EditText) findViewById(R.id.password);


        Button btnLogin = (Button) findViewById(R.id.sign_in);
        // TextView applyForMembership = findViewById(R.id.applyForMembership);
       // TextView forgotPassword = findViewById(R.id.forgotPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hud = KProgressHUD.create(v.getContext())
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("")
                        .setCancellable(false)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show();

                Login(edtUserName.getText().toString(), edtPassword.getText().toString());
                hud.dismiss();
            }
        });

    }

    private void Login(String userName, String password) {


        final Context activityContext = this;
         userService.loginAsync(userName,password, MubutoFirebaseMessagingService.getToken(),
                 new MubutoCallBack<LoginResponse>() {


                     @Override
                     public void onSuccess(Call<LoginResponse> call, LoginResponse response) {
                         hud.dismiss();
                         activityContext.startActivity(new Intent(getApplicationContext(), MainActivity.class));
                         //getApplicationContext().startActivity(new Intent(getApplicationContext(), MainActivity.class));
                         finish();
                     }


                     @Override
                     public void onFailure(Call<LoginResponse> call, Throwable t) {
                         hud.dismiss();
                     }

                     @Override
                     public void onAuthenticationFailure(String message) {
                         AlertDialog.Builder builder = new AlertDialog.Builder(activityContext,
                                 R.style.AlertDialog);
                         builder.setMessage(message);
                         builder.setPositiveButton("OK", null);
                         builder.show();
                         hud.dismiss();
                     }

                     @Override
                     public void onError(int errorCode, Boolean status, String message) {
                         AlertDialog.Builder builder = new AlertDialog.Builder(activityContext,
                                 R.style.AlertDialog);
                         builder.setMessage(message);
                         builder.setPositiveButton("OK", null);
                         builder.show();
                         hud.dismiss();
                     }
                 });

    }

}






