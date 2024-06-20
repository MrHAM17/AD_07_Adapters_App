package com.example.adapters;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class myCustomBaseAdapter1 extends AppCompatActivity {

    ListView myListview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_custom_base_adapter1);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });



//  Step 1: AdapterView: here it is ListView
        myListview = findViewById(R.id.myListViewForCustomBaseAdapter);



//  step 2: Data Source: here it is Array
        String[] countries = {"India", "USA", "Germany", "Saudi Arabia", "France"};

//  step 3: Adapter: acts as a bridge between the 'Data source' & 'AdapterView'
        myCustomBaseAdapter2 myAdapter = new myCustomBaseAdapter2(this, countries);

//  step 4: Link Listview with the Adapter
        myListview.setAdapter(myAdapter);

    }
}