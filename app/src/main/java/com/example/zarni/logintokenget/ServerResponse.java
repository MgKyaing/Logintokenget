package com.example.zarni.logintokenget;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zarni on 1/30/17.
 */
public class ServerResponse implements Serializable {
    @SerializedName("token")
    private String token;

    @SerializedName("id")
    private String id;

    @SerializedName("login_name")
    private String login_name;
//
//    @SerializedName("city")
//    private String city;

    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("error")
    private Boolean error;
    @SerializedName("telephone_no")
    private String telephone_no;
    @SerializedName("status_code")
    private int statusCode;
    @SerializedName("user")
    private List<User> User = null;
    @SerializedName("city")
    private ArrayList<City> city = null;


    // @SerializedName("result")
    // private List<City> City=null;
    //public List<City>getCity()
    //{
    //  return City;
    //}

    public ArrayList<City> getresult() {
        return city;
    }

    public List<User> getuser() {
        return User;
    }

    public void getResult(String token, String login_name, String email) {
        this.token = token;
        this.login_name = login_name;
        this.id = id;
    }

    public ServerResponse(String id, String login_name, String email, String telephone_no, String password, String city) {

        this.id = id;
        this.login_name = login_name;
        this.password = password;
        this.telephone_no = telephone_no;
        this.email = email;
        //       this.city=city;
    }

    public String getloginname() {
        return login_name;
    }

    public String getId() {
        return id;
    }

    // public String getcity(){return city;}
    public void setId() {
        this.id = id;
    }

    public void setlogin_name() {
        this.login_name = login_name;
    }

    //   public void setEmail(){
    //     this.email=email;
    //}
   /* public void setResult(String result) {
        this.result = result;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public ServerResponse(String token) {
        this.token = token;
    }
    public ServerResponse(Boolean error,String result,int statusCode){
        this.statusCode = statusCode;
        this.error = error;
        this.result = result;

    }
*/
    //  public ServerResponse(String token,String email){
    //    this.Email=email;
    //}
    public String getToken() {
        return token;
    }

    //  public void setToken(String token) {
    //   this.token = token;
    //}

    public Boolean getError() {
        return error;
    }

    // public void setError(Boolean error) {
    //   this.error = error;
    //}

    //public String getEmail() {
    //  return Email;
    //}

}
