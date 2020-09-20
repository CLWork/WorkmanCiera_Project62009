package com.example.workmanciera_newhope.helpers;

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
}
