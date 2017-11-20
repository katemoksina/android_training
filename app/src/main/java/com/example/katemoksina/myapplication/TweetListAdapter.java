package com.example.katemoksina.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by katemoksina on 20/11/2017.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetViewHolder> {

    private List<Tweet> tweetList;

    public TweetListAdapter() {
        this.tweetList = new ArrayList<>();
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_tweet_ui, viewGroup, false);
        TweetViewHolder tweetViewHolder = new TweetViewHolder(view);
        tweetViewHolder.setData(tweetList.get(i));
        return tweetViewHolder;
    }

    @Override
    public void onBindViewHolder(TweetViewHolder tweetViewHolder, int i) {
        tweetViewHolder.setData(tweetList.get(i));
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public void addTweets(List<Tweet> tweets){
        tweetList.addAll(tweetList.size(), tweets);
        notifyItemRangeChanged(tweetList.size()-tweets.size(),tweets.size());
    }

    public  class TweetViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tweet_date)
        TextView tweet_date;

        @BindView(R.id.tweet_body)
        TextView tweet_body;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Tweet data){
            tweet_date.setText(data.createdAt());
            tweet_body.setText(data.body());
        }
    }
}
