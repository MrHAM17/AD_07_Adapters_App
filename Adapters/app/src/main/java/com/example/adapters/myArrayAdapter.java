package com.example.adapters;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class myArrayAdapter extends AppCompatActivity {

    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_array_adapter);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

//        Step 1: AdapterView: here it is ListView
          myListView = findViewById(R.id.listView);

//        step 2: Data Source: here it is Array
          String[] countries = {"India", "USA", "Germany", "Saudi Arabia", "France"};

//        step 3: Adapter: acts as a bridge between the 'Data source' & 'AdapterView'
          ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

//        step 4: Link Listview with the Adapter
          myListView.setAdapter(myAdapter);
    }
}