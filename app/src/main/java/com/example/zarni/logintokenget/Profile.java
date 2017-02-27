package com.example.zarni.logintokenget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

public class Profile extends AppCompatActivity {


    TextView texttoken,Username,Email;
    String Token,username,email,token;
    ConnectionHub communicator;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Token=getIntent().getExtras().getString("token");
        username=getIntent().getExtras().getString("bllaaa");
        texttoken.setText(username);
        communicator = new ConnectionHub();
        Username=(TextView)findViewById(R.id.username);
        Email=(TextView)findViewById(R.id.email);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

//                token=Token.toString();
//                useGet(token);
//            }
//        });
                                      }
//
//    private void useGet(String token){
//        communicator.useGet(token);
//    }

                                      @Subscribe
                                      public void onServerEvent(ServerEvent serverEvent) {


                                          if (!serverEvent.getServerResponse().equals(null)) {

                                              Toast.makeText(getApplicationContext(), "Success ServerEvent Respoend" + serverEvent.getServerResponse().getToken(), Toast.LENGTH_LONG).show();
                                          }


                                      }
                                  });}}

//    @Override
//    public void onResume() {
//        super.onResume();
//        BusProvider.getInstance().register(this);
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        BusProvider.getInstance().unregister(this);
//    }
//}
