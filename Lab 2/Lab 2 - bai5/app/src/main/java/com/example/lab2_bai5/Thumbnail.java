package com.example.lab2_bai5;

import android.graphics.drawable.Drawable;
import android.media.Image;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1",R.drawable.t1),
    Thumbnail2("Thumbnail 2",R.drawable.t2),
    Thumbnail3("Thumbnail 3",R.drawable.t3),
    Thumbnail4("Thumbnail 4",R.drawable.t4);
    private String name;
    private int img;
    Thumbnail (String name, int img){
        this.name=name;
        this.img=img;
    }
    public String getName(){
        return  this.name;
    }
    public int getThumbnail(){
        return  this.img;
    }
}
