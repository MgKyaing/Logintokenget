package com.example.zarni.logintokenget;

/**
 * Created by zarni on 2/7/17.
 */

public class register {
    final String login_name;
    final String email;
    final String telephone_no;
    final String password;
    final String user_type;
    final String category_id;
    register(String login_name,String email,String telephone_no, String password,String user_type,String category_id) {
        this.login_name = login_name;
        this.email=email;
        this.telephone_no=telephone_no;
        this.password = password;
        this.user_type=user_type;
        this.category_id=category_id;

    }

}
