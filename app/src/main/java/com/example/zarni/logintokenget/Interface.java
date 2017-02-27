package com.example.zarni.logintokenget;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zarni on 1/30/17.
 */

public interface Interface {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",

    })

    @POST("/api/login")
        //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> post(@Body login body);

    @GET("/api/employer/")
    Call<ServerResponse>get(
            @Query("token")String token
    );

    @POST("/api/register")
    Call<ServerResponse>registerpost(
    @Query("login_name")String login_name,
    @Query("email")String email,
    @Query("telephone_no")String telephone_no,
    @Query("password")String password,
    @Query("user_type")String user_type,
    @Query("category_id")String category_id
    );

    @GET("/api/city")
    Call<ServerResponse>all(
            @Query("id")String id,
            @Query("city")String city
    );

}
