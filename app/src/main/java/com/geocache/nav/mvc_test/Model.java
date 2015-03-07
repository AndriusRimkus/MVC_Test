package com.geocache.nav.mvc_test;

import android.content.Context;

import java.util.Observable;

/**
 * Created by Andy on 2015.03.06.
 */
public class Model extends Observable{
    private String mData;
    private static Model sModel;
    private Context mAppContext; // gali reikėti turėti context

    private Model (Context appContext) {
        mAppContext = appContext;
        // kažkokių kintamųjų realizavimas
    }

    public static Model get(Context c) {
        if (sModel == null) {
            sModel = new Model(c.getApplicationContext());
        }
        return sModel;
    }

   public String getData() {
        return mData;
    }

   public void setData(String data) {
        mData = data;
        setChanged();
        notifyObservers();
    }
}
