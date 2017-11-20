package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by katemoksina on 20/11/2017.
 */

public class TweetListPresenterImpl implements TweetListPresenter {

    private final TweetListService tweetListService;
    private TwitterListMVPView mvpView;

    public TweetListPresenterImpl(TweetListService tweetListService){
        this.tweetListService = tweetListService;
    }
    @Override
    public void getTweetList() {
        if (mvpView == null){
            return;
        }
        Call<List<Tweet>> tweetListCall = tweetListService.getTweets(mvpView.getListId(), mvpView.getTweetCount());
        tweetListCall.enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
                mvpView.onTweetsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Tweet>> call, Throwable t) {
                mvpView.onTweetsLoadError(t);
            }
        });
    }

    @Override
    public void setMVPView(TwitterListMVPView mvpView) {
        this.mvpView = mvpView;
    }
}
