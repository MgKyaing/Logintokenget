package com.example.zarni.logintokenget;

import com.squareup.otto.Bus;

/**
 * Created by zarni on 1/30/17.
 */
public class BusProvider {


    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
