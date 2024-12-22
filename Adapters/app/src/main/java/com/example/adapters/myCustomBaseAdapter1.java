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



//  Step 1: AdapterView: This is the UI component that displays the data. 
//          Here, it is a ListView (`myListViewForCustomBaseAdapter`).

        myListview = findViewById(R.id.myListViewForCustomBaseAdapter);



// Step 2: Data Source: This is the collection of data that will be displayed in the AdapterView. 
//         Here, it is a String array containing country names.

        String[] countries = {"India", "USA", "Germany", "Saudi Arabia", "France"};

// Step 3: Adapter: The adapter acts as a bridge between the d'Data source' & 'AdapterView'. 
//         It prepares the data and populates the AdapterView with it.

        myCustomBaseAdapter2 myAdapter = new myCustomBaseAdapter2(this, countries);

// Step 4: Link the ListView with the Adapter using the `setAdapter` method. 
//         This step connects the data source to the ListView for display.

        myListview.setAdapter(myAdapter);

    }
}
