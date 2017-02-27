package com.example.zarni.logintokenget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Subscribe;

public class Josnspinner extends AppCompatActivity {
    private Button button;
    private ConnectionHub communicator;
    private String Id,City,id,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_josnspinner);


        android.widget.Spinner spinner=(android.widget.Spinner) findViewById(R.id.spinner1);
        communicator=new ConnectionHub();
        button=(Button)findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getcity();
//            }
//        });
    }


//    private void getcity(){
//
//        communicator.getcity();
//
//    }

//    String[] arrConuntry=new String[data.size()];
//    for(int index=0;index<data.size();i++){
//        HashMap<String, String> map=data.get(index);J
//        arrConuntry[index]=map.get(COUNTRY_NAME);
//    }
//    // pass arrConuntry array to ArrayAdapter<String> constroctor :
//    adaptercountry = new ArrayAdapter<String>(getActivity(),
//    android.R.layout.simple_spinner_dropdown_item,
//    arrConuntry);

    @Subscribe
    private void onServerEvent(ServerEvent serverEvent){
        if (!serverEvent.getServerResponse().getresult().equals(null))
        {
        }
    }


}
