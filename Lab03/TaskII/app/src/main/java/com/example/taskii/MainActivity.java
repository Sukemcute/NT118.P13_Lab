package com.example.taskii;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taskii.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactListView;
    private ArrayAdapter<String> adapter;
    private List<Contact> contactList;
    private DatabaseHandler db;
    private List<String> contactDisplayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contactListView = findViewById(R.id.contact_item);
        db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));


        loadContacts();
        contactListView.setOnItemLongClickListener((parent, view, position, id) -> {
            Contact contact = contactList.get(position);
            db.deleteContact(contact);
            Toast.makeText(MainActivity.this, "Deleted: " + contact.getName(), Toast.LENGTH_SHORT).show();
            loadContacts();
            return true;
        });
    }

    private void loadContacts() {
        contactList = db.getAllContacts();
        contactDisplayList = new ArrayList<>();

        Log.e("Reading: ", "Reading all contacts..");
        for (Contact cn : contactList) {
            String contactInfo = "Name: " + cn.getName() + "\nPhone: " + cn.getPhoneNumber();
            contactDisplayList.add(contactInfo);
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            Log.e("Name: ", log);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactDisplayList);
        contactListView.setAdapter(adapter);
    }
}