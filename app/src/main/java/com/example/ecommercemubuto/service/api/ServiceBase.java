package com.example.ecommercemubuto.service.api;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.ecommercemubuto.MainActivity;
import com.example.ecommercemubuto.R;
import com.example.ecommercemubuto.ui.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ServiceBase {
    private static Context _applicationContext;
    private static MubutoApi mubutoApi;


    private static void createApi() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mubutoApi.BASE_URL)
                //.client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mubutoApi = retrofit.create(MubutoApi.class);
    }

    protected static MubutoApi getMubutoApi() {
        if (mubutoApi == null) {
            createApi();
        }
        return mubutoApi;
    }

    public static void setApplicationContext(LoginActivity loginActivity) {
    }

    public <T> void getAsync(Call<T> call, final MubutoCallBack<T> callback) {
        call.enqueue(new Callback<T>() {

            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                T responseBody = response.body();

                callback.onSuccess(call, responseBody);
            }


            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure(call, t);

                String failureMessage = t.getMessage();
                String alertMessage = "";
                if (failureMessage.contains("Unable to resolve host")) {
                    alertMessage = "Check your internet connection";
                }

                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ServiceBase.getApplicationContext(),
                            R.style.AlertDialog);
                    builder.setMessage(alertMessage);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (ServiceBase.getApplicationContext() instanceof MainActivity) {
                                AppCompatActivity caller = (AppCompatActivity) ServiceBase.getApplicationContext();
                                caller.finish();
                            }
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                } catch (Exception e) {
                }
                /*
                Toast.makeText(ServiceBase.getApplicationContext(),
                        "Check your internet connection", Toast.LENGTH_LONG)
                        .show();
                        */
            }
        });
    }
    public <T> T get(Call<T> call) throws IOException, AuthenticationException, ApiException {
        T responseBody = call.execute().body();

        return responseBody;
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static void setApplicationContext(Context applicationContext) {
        _applicationContext = applicationContext;
    }



}

