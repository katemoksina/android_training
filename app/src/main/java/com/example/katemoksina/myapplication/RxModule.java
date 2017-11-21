package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.AndroidObservableConfigurer;
import com.example.katemoksina.myapplication.ObservableConfigurer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sverma on 08/06/2017.
 */

@Module
public class RxModule {

    @Provides @Singleton
    public ObservableConfigurer provideObservableConfigurer() {
        return new AndroidObservableConfigurer();
    }

}
