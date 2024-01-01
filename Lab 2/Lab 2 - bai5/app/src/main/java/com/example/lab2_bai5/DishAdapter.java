package com.example.lab2_bai5;

import static com.example.lab2_bai5.R.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DishAdapter extends ArrayAdapter<Dish>{

    private  Context context;
    private  int resource;
    ArrayList<Dish> listDish;
    public DishAdapter(Context context, int resource, ArrayList<Dish> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listDish=objects;
    }

    @Override
    public View getView(final int position,View convertView, @NonNull ViewGroup parent) {
        View viewDish= LayoutInflater.from(context).inflate(layout.item_dish,null,false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView dishName=viewDish.findViewById(id.dishName);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView dishImg=viewDish.findViewById(id.imageViewDish);
        ImageView isPromotion=viewDish.findViewById(id.promotion);
        dishName.setText(listDish.get(position).getName());
        Drawable drawable=context.getDrawable(listDish.get(position).getImage());
        dishImg.setImageDrawable(drawable);
        if (listDish.get(position).getPromotion()==false){
            isPromotion.setVisibility(View.GONE);
        }
        return viewDish;
    }
}

