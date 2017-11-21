package com.example.katemoksina.myapplication.model;

import com.example.katemoksina.myapplication.model.Entities;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class QuotedStatus {
    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("full_text")
    public abstract String fullText();

    @SerializedName("truncated")
    public abstract boolean truncated();

    @SerializedName("entities")
    public abstract Entities entities();

    public static TypeAdapter<QuotedStatus> typeAdapter(Gson gson) {
        return new AutoValue_QuotedStatus.GsonTypeAdapter(gson);
    }
}
