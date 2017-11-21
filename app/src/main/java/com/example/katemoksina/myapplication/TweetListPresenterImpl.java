package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DefaultObserver;

/**
 * Created by katemoksina on 20/11/2017.
 */

public class TweetListPresenterImpl implements TweetListPresenter {

    private final TweetListService tweetListService;
    private final ObservableConfigurer observableConfigurer;
    private TwitterListMVPView mvpView;

    public TweetListPresenterImpl(TweetListService tweetListService, ObservableConfigurer observableConfigurer){
        this.tweetListService = tweetListService;
        this.observableConfigurer = observableConfigurer;
    }
    @Override
    public void getTweetList() {
        if (mvpView == null){
            return;
        }
        Observable<List<Tweet>> tweetListObservable = tweetListService.getTweets(mvpView.getListId(), mvpView.getTweetCount());

        observableConfigurer.configureObservable(tweetListObservable)
                .subscribe(new DefaultObserver<List<Tweet>>(){
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
