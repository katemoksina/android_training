package com.example.katemoksina.myapplication;

/**
 * Created by katemoksina on 20/11/2017.
 */


public interface TweetListPresenter {
    void getTweetList();
    void setMVPView(TwitterListMVPView mvpView);
}
