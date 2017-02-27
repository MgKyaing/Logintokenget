package com.example.zarni.logintokenget;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.security.Timestamp;

/**
 * Created by zarni on 2/2/17.
 */

public class ServerResponseLogin implements Serializable {
    @SerializedName("token")
    private String token;

    @SerializedName("id")
    private String id;

    @SerializedName("login_name")
    private String login_name;

    @SerializedName("email")
    private String Email;

    @SerializedName("telephone_no")
    private String telephone_no;

    @SerializedName("password")
    private String password;

    @SerializedName("is_admin")
    private String is_admin;

    @SerializedName("is_active")
    private String is_active;

    @SerializedName("user_type")
    private String user_type;

    @SerializedName("remember_token")
    private String remember_token;

    @SerializedName("created_at")
    private Timestamp created_at;

    @SerializedName("updated_at")
    private Timestamp updated_at;

    @SerializedName("api_token")
    private String api_token;

    @SerializedName("category_id")
    private String category_id;

    @SerializedName("error")
    private Boolean error;

    @SerializedName("result")
    private String result;

    @SerializedName("status_code")
    private int statusCode;



    public void getServerResponseLogin(String token,String id ,String login_name,String email,String telephone_no,
                                       String password,String is_admin,String is_active,String user_type,String remember_token,Timestamp created_at,Timestamp updated_at
    ,String api_token,String category_id)
    {
        this.token=token;
        this.id=id;
        this.login_name=login_name;
        this.Email=email;
        this.telephone_no=telephone_no;
        this.password=password;
        this.is_admin=is_admin;
        this.is_active=is_active;
        this.user_type=user_type;
        this.remember_token=remember_token;
        this.api_token=api_token;
        this.category_id=category_id;

    }

public String getId(){
    return id;
}
public String getEmail(){
    return Email;
}





}
