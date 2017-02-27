package com.example.zarni.logintokenget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ConnectionHub communicator;
    private String login_name, password;
    private EditText usernameET, passwordET;
    private Button loginButtonPost,buttontospi, loginButtonGet, bottonMm, bottonEng;
    public static String token,email;
    private TextView information, extraInformation,gotoregister,gotospinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gotoregister=(TextView)findViewById(R.id.toregister);
        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Tenerifesea.class);
                    startActivity(intent);
            }
        });

        gotospinner=(TextView)findViewById(R.id.buttontospinner);
        gotospinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Tenerifesea.class);
                startActivity(intent);
            }
        });
        communicator = new ConnectionHub();
        usernameET = (EditText) findViewById(R.id.edit_text_email);
        passwordET = (EditText) findViewById(R.id.edit_text_password);
        extraInformation = (TextView) findViewById(R.id.edit_text_extra_info);
        loginButtonPost = (Button) findViewById(R.id.btn_login);
        loginButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_name = usernameET.getText().toString();
                password = passwordET.getText().toString();
                usePost(login_name, password);

            }
        });
    }

    private void usePost(String login_name, String password) {
        communicator.loginPost(login_name, password);
    }




    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {
        if (!serverEvent.getServerResponse().equals(null)) {
            List<User> users=serverEvent.getServerResponse().getuser();
          User  user=users.get(0);
            String bllaaa = user.getid();
            Toast.makeText(getApplicationContext(),bllaaa,Toast.LENGTH_LONG).show();

            // Toast.makeText(getApplicationContext(), "Success ServerEvent Respond" + serverEvent.getServerResponse().getlogin(), Toast.LENGTH_LONG).show();

            //
            // extraInformation.setText("" + serverEvent.getServerResponse());
            //token = serverEvent.getServerResponse().getToken();
           Intent intent = new Intent(this, Profile.class);
            intent.putExtra("token", token);
            intent.putExtra("id",bllaaa);
            startActivity(intent);

            // Intent intent = new Intent(MainLoginActivity.this, JFirstMenuPage.class);
            //    startActivity(intent)
        }


  //       if (serverEvent.getServerResponse().getToken() != null) {
    //     information.setText("Username: " + serverEvent.getServerResponse().getToken() + " || Password: " + serverEvent.getServerResponse().getPassword());
      //       }

    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }


}



