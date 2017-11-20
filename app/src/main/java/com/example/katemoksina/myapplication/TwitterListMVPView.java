package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;

/**
 * Created by katemoksina on 20/11/2017.
 */

public interface TwitterListMVPView {
    String getListId();
    int getTweetCount();
    void onTweetsLoaded(List<Tweet> tweets);
    void onTweetsLoadError(Throwable throwable);
    void onTweetsLoadComplete();
}