package com.example.katemoksina.myapplication.model;

import android.net.Uri;

/**
 * Created by sverma on 12/06/2017.
 */

public class ImageUri {

    private Uri uri;

    private int width;

    private int height;

    public ImageUri(Uri uri, int width, int height) {
        this.uri = uri;
        this.width = width;
        this.height = height;
    }


    public Uri getUri() {
        return uri;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
