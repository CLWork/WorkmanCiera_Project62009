//Ciera Workman
//Project 6 2009
//Sponsors.java

package com.example.workmanciera_newhope.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Sponsors {

    private String name;
    private String imgURL;

    public Sponsors(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    public Sponsors(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Bitmap bitmapFromUrl(String url) throws IOException {
        Bitmap imgFromUrl;

        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        imgFromUrl = BitmapFactory.decodeStream(input);
        return imgFromUrl;
    }
}
