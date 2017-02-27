package com.example.zarni.logintokenget;

import android.os.AsyncTask;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zarni on 2/27/17.
 */

public class DBConnect {

    ConnectionHub connectionHub;
    String id,city;
    private List bla = new ArrayList<>();
    private List za = new ArrayList<>();
    Database database=new Database(this);
    HashMap<String ,String >queryValues;
    public void DBConnect() {

        connectionHub = new ConnectionHub();
        id="";
           city="";
           getcity(id,city);
    }

    public void getcity(String id, String city) {
        connectionHub.getcity(id, city);
    }

    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {
        if (!serverEvent.getServerResponse().equals(null)) {

            List<City>cities=serverEvent.getServerResponse().getresult();
                for(int i=0;i<cities.size();i++)

                {
//                    bla.add(cities.get(i).getcity());
//                    za.add(cities.get(i).getid());
////                    queryValues=new HashMap<String ,String >();
//                    queryValues.put(cities.get(i).getcity())
                }

        }
    }
}