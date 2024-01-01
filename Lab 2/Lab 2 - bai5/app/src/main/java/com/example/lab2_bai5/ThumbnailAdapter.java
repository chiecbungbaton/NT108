package com.example.lab2_bai5;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Context context=null;
    private int layout;
    private ArrayList<Thumbnail> thumbnailList=null;
    public ThumbnailAdapter(Context context, int resource,ArrayList<Thumbnail> objects) {
        super(context,resource,objects);
        Log.d("test","test");
        Log.i("test", objects.get(0).getName());
        this.context = context;
        this.layout = layout;
        this.thumbnailList = objects;
    }
    @Override
    public int getCount() {
        return thumbnailList.size();
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_thumbnail, parent, false);
        TextView textView=row.findViewById(R.id.item_tv_thumbnailName);
        ImageView imgThumbnail=row.findViewById(R.id.item__iv_thumbnail);

        Drawable drawable = context.getResources().getDrawable(thumbnailList.get(position).getThumbnail());

        //Set state abbreviation and state flag
        textView.setText(thumbnailList.get(position).getName());
        imgThumbnail.setImageDrawable(drawable);
        return row;

    }
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_thumbnail, parent, false);

        TextView thbName = row.findViewById(R.id.item_tv_thumbnailName);

        thbName.setText(thumbnailList.get(position).getName());

        return row;
    }
}
