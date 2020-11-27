package com.example.mycontactmanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mycontactmanager.data.DatabaseHandler;
import com.example.mycontactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact first = new Contact();
        /*
        Contact first = new Contact();
        first.setName("Premnath");
        first.setPhoneNumber("6382709971");
        db.addContact(first);
        */

        /*
        Contact second = new Contact();
        second.setName("Priya");
        second.setPhoneNumber("9791793785");
        db.addContact(second);


// get all contacts

       List<Contact> contactList = db.getAllContacts();

        for (Contact contact : contactList) {
            Log.d("MainActivity5", "onCreate: " + contact.getId());
            //contactArrayList.add(contact.getName());
        }
// get one contact

        Contact contact_one = db.getContact(1);
        Log.d("MainActivity", "onCreate: " + contact_one.getId() + " " + contact_one.getName() + " ,"+ contact_one.getPhoneNumber());

  //update
        contact_one.setName("Priya");
        contact_one.setPhoneNumber("9791793785");
        int updatedRow = db.updateContact(contact_one);
        Log.d("MainActivity", "onCreate: " + updatedRow + " " + contact_one.getId() + " " + contact_one.getName() + " ,"+ contact_one.getPhoneNumber());
        */
   //delete
       // db.deleteContact(2);
        Log.d("main", "onCreate: "+ db.getCount());
    }

}
