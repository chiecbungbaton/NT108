package com.example.lab2_bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView selectedItemTextView;
    private Button button;
    private EditText editTextmaNV, editTexttenNV;
    private RadioButton fullTime, partTime;
    private RadioGroup rgType;
    private ArrayList<String> listNV;
    private ArrayAdapter<String> adapter;
    private Employee employee;

    public class Employee {
        String tenNV;
        String maNV;

        public void setId(String id) {
            this.maNV = id;
        }

        public void setName(String name) {
            this.tenNV = name;
        }
    }

    public class EmployeeFulltime extends Employee {
        public double tinhLuong() {
            return 500.0;
        }

        @Override
        public String toString() {
            return " --> FullTime = 500.0";
        }
    }

    public class EmployeeParttime extends Employee {
        public double tinhLuong() {
            return 150.0;
        }

        @Override
        public String toString() {
            return " --> PartTime = 150.0";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.buttonNhapNV);
        editTextmaNV = findViewById(R.id.inputMaNV);
        editTexttenNV = findViewById(R.id.inputTenNV);
        fullTime = findViewById(R.id.buttonChinhThuc);
        partTime = findViewById(R.id.buttonThoiVu);
        rgType = findViewById(R.id.rgType);

        listNV = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNV);
        listView.setAdapter(adapter);
        rgType.clearCheck();
        editTextmaNV.setText("");
        editTexttenNV.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                selectedItemTextView.setText("Position: " + position + ", value = " + selectedItem);
            }
        });
    }

    public void addNewEmployee() {
        int radId = rgType.getCheckedRadioButtonId();
        String id = editTextmaNV.getText().toString();
        String name = editTexttenNV.getText().toString();

        if (radId == R.id.buttonChinhThuc) {
            employee = new EmployeeFulltime();
        } else {
            employee = new EmployeeParttime();
        }

        employee.setId(id);
        employee.setName(name);

        String employeeInfo = id + " - " + name + employee.toString();
        listNV.add(employeeInfo);
        adapter.notifyDataSetChanged();

        editTextmaNV.setText("");
        editTexttenNV.setText("");
        rgType.clearCheck();
    }
}