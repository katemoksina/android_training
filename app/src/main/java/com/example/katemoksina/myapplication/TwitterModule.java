package com.example.katemoksina.myapplication;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katemoksina on 20/11/2017.
 */

@Module
public class TwitterModule {

    @Provides @Singleton
    public TweetListPresenter provideTwitterPresenter(TweetListService tweetListService, ObservableConfigurer observableConfigurer){
        return new TweetListPresenterImpl(tweetListService, observableConfigurer);
    }

    @Provides @Singleton
    public TweetListService provideTwitterService(TwitterAPI twitterAPI){
        return new TweetListServiceImpl(twitterAPI);
    }
}
