package com.example.katemoksina.myapplication;

import com.example.katemoksina.myapplication.model.Tweet;

import java.util.List;

import retrofit2.Call;

/**
 * Created by katemoksina on 20/11/2017.
 */

public interface TweetListService {
    Call<List<Tweet>> getTweets(String listId, int count);
}
