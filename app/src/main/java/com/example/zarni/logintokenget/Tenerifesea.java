package com.example.zarni.logintokenget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Tenerifesea extends Activity {
    ConnectionHub communicator;
    private List bla = new ArrayList<>();
    private List za = new ArrayList<>();
    private int dftindex = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenerifesea);
        communicator = new ConnectionHub();
        String id = "";
        String city = "";
        getcity(id, city);


    }

    private void getcity(String id, String city) {
        communicator.getcity(id, city);
    }

    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {
        if (!serverEvent.getServerResponse().equals(null)) {
            List<City> cities = serverEvent.getServerResponse().getresult();
            for (int i = 0; i < cities.size(); i++) {
                bla.add(cities.get(i).getcity());
                za.add(cities.get(i).getid());
            }

             spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bla);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   String spinnerid =za.get(position).toString();
                    String cityname=bla.get(position).toString();
                Toast.makeText(getApplicationContext(),spinnerid+cityname,Toast.LENGTH_LONG).show();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


//     AdapterView.OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
//            spinner.setOnItemSelectedListener(spinnerListener);
//        //      spinner.setSelection(dftindex);

//            spinner. setOnItemSelectedListener(new myOnItemSelectedListener());

//            Toast.makeText(getApplicationContext(),bla+"dii",Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(),za+"dii",Toast.LENGTH_LONG).show();
        }
        //System.out.print(serverEvent.getServerResponse().getresult());
    }
//
//    public class myOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
//        String firstItem=String.valueOf(spinner.getSelectedItem());
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            if (firstItem.equals(String.valueOf(spinner.getSelectedItem())))
//            {
//
//            }
//            else {
//                Toast.makeText(getApplicationContext(),"Yout choose "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
//            }
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    }

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
