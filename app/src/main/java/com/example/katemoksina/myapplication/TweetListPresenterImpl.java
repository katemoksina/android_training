package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DefaultObserver;
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
        Observable<List<Tweet>> tweetListObservable = tweetListService.getTweets(mvpView.getListId(), mvpView.getTweetCount());

        tweetListObservable.subscribe(new DefaultObserver<List<Tweet>>(){
            @Override
            public void onNext(List<Tweet> value) {
                mvpView.onTweetsLoaded(value);
            }

            @Override
            public void onError(Throwable e) {
                mvpView.onTweetsLoadError(e);
            }

            @Override
            public void onComplete() {
                mvpView.onTweetsLoadComplete();
            }
        });
    }

    @Override
    public void setMVPView(TwitterListMVPView mvpView) {
        this.mvpView = mvpView;
    }
}
