package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
public class MainActivity extends AppCompatActivity {
    private LinearLayout llNameContainer, llAddressContainer, llParentContainer;
    private void createNameContainer() {
        llNameContainer = new LinearLayout(this);
        llNameContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        llNameContainer.setOrientation(LinearLayout.HORIZONTAL);
        TextView tvName = new TextView(this);
        llNameContainer.addView(tvName);
        TextView tvNameValue = new TextView(this);
        llNameContainer.addView(tvNameValue);
    }
    private void createAddressContainer() {
        llAddressContainer = new LinearLayout(this);
        llAddressContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        llAddressContainer.setOrientation(LinearLayout.HORIZONTAL);
        TextView tvAddress = new TextView(this);
        llAddressContainer.addView(tvAddress);
        TextView tvAddressValue = new TextView(this);
        llAddressContainer.addView(tvAddressValue);
    }
    private void createParentContainer() {
        llParentContainer = new LinearLayout(this);
        llParentContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        llParentContainer.setOrientation(LinearLayout.VERTICAL);
        llParentContainer.addView(llNameContainer);
        llParentContainer.addView(llAddressContainer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);
        createNameContainer();
        createAddressContainer();
        createParentContainer();

    }

}