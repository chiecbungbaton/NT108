package com.example.lab2_bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText inputID, inputName;
    private CheckBox isManager;
    private Button add;
    private ArrayList<Employee> employeeList;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputID = findViewById(R.id.editTextID);
        inputName = findViewById(R.id.editTextName);
        isManager = findViewById(R.id.checkBox);
        add = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        employeeList = new ArrayList<Employee>();
        adapter = new EmployeeAdapter(this, android.R.layout.simple_list_item_1, employeeList);
        listView.setAdapter(adapter);
        inputName.setText("");
        inputID.setText("");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=inputName.getText().toString();
                Boolean manager=isManager.isChecked();
                Employee employee = new Employee();
                employee.setName(name);
                employee.setManager(manager);
                employeeList.add(employee);
                adapter.notifyDataSetChanged();
                inputID.setText("");
                inputName.setText("");
            }
        });
    }


}