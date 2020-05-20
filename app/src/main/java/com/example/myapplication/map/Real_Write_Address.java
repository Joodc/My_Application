package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Real_Write_Address extends AppCompatActivity {
    String ADDRESS;
    Button map_search_button, search_button, next_page_button;
    EditText frame_address, detail_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_address);

        map_search_button = findViewById(R.id.map_search_button);
        search_button = findViewById(R.id.search_button);
        next_page_button = findViewById(R.id.next_page_button);
        frame_address = findViewById(R.id.frame_address);
        detail_address = findViewById(R.id.detail_address);

        Intent intent = getIntent();
        /*
        ADDRESS = intent.getExtras().getString("location");
        frame_address.setText(ADDRESS);
         */

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });
        map_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Map_Search.class);
                startActivity(intent);
            }
        });
        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("location", ADDRESS);
                startActivity(intent);
            }
        });
    }
}
