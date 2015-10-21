package com.theironyard.contactsandrois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> contacts;
    ListView listView;
    Button addButton;
    EditText nameField;
    EditText phoneField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView)findViewById(R.id.listView);
        addButton = (Button)findViewById(R.id.addButton);
        nameField= (EditText)findViewById(R.id.nameField);
        phoneField = (EditText)findViewById(R.id.phoneField);

        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);

        contacts = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);
    }

    @Override
    public void onClick(View v) {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String newContact = String.format("%s %s %s %s",name,"(",phone,")");
        contacts.add(newContact);
        nameField.setText("");
        phoneField.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String itemToRemove = contacts.getItem(position);
        contacts.remove(itemToRemove);
        return true;
    }
}
