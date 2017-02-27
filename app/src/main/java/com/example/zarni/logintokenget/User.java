package com.example.zarni.logintokenget;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 2/6/17.
 */

public class User implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("login_name")
    private String login_name;

    @SerializedName("password")
    private String password;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String login_name, String password) {
        this.id = id;
        this.login_name = login_name;
        this.password = password;
    }


    public String getid(){
    return id;

}

 public String getLogin_name()
 {
     return login_name;
 }
}
