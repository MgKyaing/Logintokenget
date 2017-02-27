package com.example.zarni.logintokenget;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zarni on 1/30/17.
 */

public class ConnectionHub {

    private static  final String TAG = "ConnectionHub";
    private static final String SERVER_URL = "http://goldenictsolutions.com/";
    private static final String token = MainActivity.token;

    public void loginPost(String login_name, String password){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);
        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<ServerResponse> call = service.post(new login(login_name,password));
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx

                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }
    public void registerpost(String login_name,String email,String telephone_no, String password,String user_type,String category_id){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);

        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<ServerResponse> call = service.registerpost(login_name,email,telephone_no,password,user_type,category_id);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx

                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }


//    public void useGet(String token){
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClient.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(SERVER_URL)
//                .build();
//        Interface service = retrofit.create(Interface.class);
//        //Call<ServerResponse> call = service.post("login",username,password);
//        //Call<ServerResponse> call = service.post(username,password);
//        Call<ServerResponse> call = service.get(token);
//        //Call<ServerResponse> call = service.post(username,password);
//        call.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
//                // response.isSuccessful() is true if the response code is 2xx
//            //    Log.e(TAG, "Success"+response.code());
//            //    Log.e(TAG, "Success"+response.body());
//             //   Log.e(TAG, "Success"+response.message());
//                BusProvider.getInstance().post(new ServerEvent(response.body()));
//                Log.e(TAG, "Success");
//            }
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//                // handle execution failures like no internet connectivity
//                Log.e(TAG, "Failure "+t.getMessage());
//                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
//            }
//        });
//    }
        public void getcity(String id,String city){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);
        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<ServerResponse> call = service.all(id,city);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));

            }
        });
    }
}
