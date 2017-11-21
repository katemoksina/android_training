package com.example.katemoksina.myapplication;


import io.reactivex.Observable;

/**
 * Created by sverma on 12/06/2017.
 */

public interface ObservableConfigurer {
     <T>Observable<T> configureObservable(Observable<T> observable);
}
