package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by katemoksina on 20/11/2017.
 */

public class TweetListServiceImpl implements TweetListService {

    private final TwitterAPI twitterApi;

    public TweetListServiceImpl(TwitterAPI twitterApi){
        this.twitterApi = twitterApi;
    }

    @Override
    public Observable<List<Tweet>> getTweets(String listId, int count) {
        return twitterApi.getTweets(listId,"extended",1, count);
    }


}
