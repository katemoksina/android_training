package com.example.katemoksina.myapplication;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katemoksina on 20/11/2017.
 */

@Module
public class MyApplicationModule {
    private final Application application;

    public MyApplicationModule(Application application){
        this.application = application;
    }

    @Provides @Singleton
    public Context provideContext(){ return application;};
}
