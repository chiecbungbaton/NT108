package com.example.lab2_bai6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button add;
    EditText inputID, inputName;
    CheckBox isManager;
    ArrayList<Employee> employeeList;
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.button);
        inputID = findViewById(R.id.editTextID);
        inputName = findViewById(R.id.editTextName);
        isManager = findViewById(R.id.checkBox);
        recyclerView = findViewById(R.id.recyclerview);
        employeeList = new ArrayList<Employee>();
        adapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        inputName.setText("");
        inputID.setText("");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee();
                String name = inputName.getText().toString();
                Boolean manager = isManager.isChecked();
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