package com.example.katemoksina.myapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by katemoksina on 20/11/2017.
 */

@Singleton
@Component(modules = {MyApplicationModule.class, TwitterModule.class, ApiModule.class, RxModule.class})
public interface MyApplicationComponent {
    void inject(MainActivity target);

}
