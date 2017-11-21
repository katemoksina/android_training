package com.example.katemoksina.myapplication;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sverma on 12/06/2017.
 */

public class AndroidObservableConfigurer implements ObservableConfigurer {

    @Override
    public <T>Observable<T> configureObservable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
