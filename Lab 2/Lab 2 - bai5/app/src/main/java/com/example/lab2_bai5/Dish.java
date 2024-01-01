package com.example.lab2_bai5;

import android.media.Image;

public class Dish {
    private String name;
    private int thumbnail;
    private Boolean  promotion;
    public  Dish(String name,int thumbnail, Boolean promotion){
        this.name=name;
        this.thumbnail=thumbnail;
        this.promotion=promotion;
    }
    public String getName(){
        return  this.name;
    }
    public int getImage(){
        return this.thumbnail;
    }
    public Boolean getPromotion(){
        return this.promotion;
    }
}
