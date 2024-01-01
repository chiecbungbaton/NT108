package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHandler dbHandler;
    private List<Contact> contacts;
    private ArrayAdapter<String> contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DatabaseHandler(this);
        dbHandler.deleteAllContacts();

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        dbHandler.addContact(new Contact("Ravi", "9100000000"));
        dbHandler.addContact(new Contact("Srinivas", "9199999999"));
        dbHandler.addContact(new Contact("Tommy", "9522222222"));
        dbHandler.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        contacts = dbHandler.getAllContacts();


        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhone();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        List<String> formattedContacts = new ArrayList<>();
        for (Contact cn : contacts) {
            String showContact = String.format("Name: %s - Phone: %s",
                 cn.getName(), cn.getPhone());
            formattedContacts.add(showContact);
        }

        ListView listView = findViewById(R.id.listContacts);
        contactAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, formattedContacts);
        listView.setAdapter(contactAdapter);

        // Set long click listener to delete the contact
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contacts.get(position);
                dbHandler.deleteContact(selectedContact);
                contacts.remove(position);
                formattedContacts.remove(position);
                contactAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Contact deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}