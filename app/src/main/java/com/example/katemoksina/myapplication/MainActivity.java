package com.example.katemoksina.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TwitterListMVPView{

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tweet_list)
    RecyclerView tweetList;

    private TweetListAdapter tweetListAdapter;

    @Inject
    TweetListPresenter tweetListPresenter;

    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getApplication()).getMyApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tweetListPresenter.setMVPView(this);

        tweetList.setLayoutManager(new LinearLayoutManager(this));

        tweetListAdapter = new TweetListAdapter(context);
        tweetList.setAdapter(tweetListAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        tweetListPresenter.getTweetList();
    }

    @Override
    public String getListId() {
        return getString(R.string.twitter_list_id);
    }

    @Override
    public int getTweetCount() {
        return 10;
    }

    @Override
    public void onTweetsLoaded(List<Tweet> tweets) {
        Log.d(TAG, tweets.size() + " tweets loaded");
        tweetListAdapter.addTweets(tweets);
    }

    @Override
    public void onTweetsLoadError(Throwable throwable) {
       Log.e(TAG, "Failed to load tweets " + throwable.getMessage());
    }

    @Override
    public void onTweetsLoadComplete() {

    }
}
