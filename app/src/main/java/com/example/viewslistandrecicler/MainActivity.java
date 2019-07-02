package com.example.viewslistandrecicler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    ListView listView;
    EditText etCount;
    Button btnLoad;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        listView = findViewById(R.id.lv_list);
        etCount = findViewById(R.id.et_count_value);
        btnLoad = findViewById(R.id.btn_load);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> data = fetchData();
                setupListView(data);
            }
        });
    }
//
//    private List<String> fetchData() {
//        return null;
//    }


    private void setupListView(List<String> data) {
        Log.d(TAG, "setupListView:" + data);


        // Declare and Init our adapter
        StableArrayAdapter adapter = new StableArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, data);

        // set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set onItemClickListener to ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // retrieve the value from the parent using the position passed in
                String value = (String) parent.getItemAtPosition(position);
                // Toast to show value that was clicked
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> fetchData() {
        // Declaring and Init values
        List<String> list = new ArrayList<>();
        int count;
        String etValue = etCount.getText().toString();

        // Will try to run code in the try scope first
        // if that fails will run code in the catch scope
        try {
            count = Integer.valueOf(etValue);
        } catch (Exception ex) {
            count = 10;
        }

        // loop that adds numbers to the list
        for (int i = 0; i < count; i++) {
            list.add("" + i);
        }

        // returns the list
        return list;
    }
}

