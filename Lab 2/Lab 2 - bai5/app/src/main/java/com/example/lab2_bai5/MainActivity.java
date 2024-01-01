package com.example.lab2_bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Thumbnail> dishArrayList;
    ArrayAdapter<Thumbnail> adapter;

    ArrayList<Dish> itemDish;
    ArrayAdapter<Dish>  dishArrayAdapter;
    EditText editTextName;
    CheckBox pro;
    int  thumbSelected;
    Button buttonAdd;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinnerDropDown);
        dishArrayList=new ArrayList<Thumbnail>();
        dishArrayList.add(Thumbnail.Thumbnail1);
        dishArrayList.add(Thumbnail.Thumbnail2);
        dishArrayList.add(Thumbnail.Thumbnail3);
        dishArrayList.add(Thumbnail.Thumbnail4);
        adapter=new ThumbnailAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dishArrayList);
        spinner.setAdapter(adapter);
        editTextName=findViewById(R.id.editTextName);
        pro=findViewById(R.id.checkBox);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                thumbSelected=dishArrayList.get(position).getThumbnail();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonAdd =findViewById(R.id.button);
        buttonAdd.setOnClickListener(v -> add());
        itemDish=new ArrayList<Dish>();
        dishArrayAdapter= new DishAdapter(this, android.R.layout.simple_list_item_2,itemDish);
        gridView=findViewById(R.id.gridViewDish);
        gridView.setAdapter(dishArrayAdapter);
    }
    private void add(){
        String dishName=editTextName.getText().toString();
        Boolean check=pro.isChecked();
        Dish dish=new Dish(dishName,thumbSelected,check);
        itemDish.add(dish);
        dishArrayAdapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
        editTextName.setText("");
        pro.setChecked(false);
        spinner.setSelection(0);
    }
}