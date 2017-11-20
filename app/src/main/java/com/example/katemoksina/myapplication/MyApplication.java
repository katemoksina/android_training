package com.example.katemoksina.myapplication;

import android.app.Application;
import android.os.Bundle;

/**
 * Created by katemoksina on 20/11/2017.
 */

public class MyApplication extends Application{

    private MyApplicationComponent myApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        myApplicationComponent = DaggerMyApplicationComponent.builder().myApplicationModule(
                new MyApplicationModule(this)).build();
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }
}
