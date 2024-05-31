package com.test.kaarigar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class chooselocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chooselocation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] loclist = {"Karachi" , "Islamabad" , "Lahore" , "Peshawar" , "Quetta" , "Balochistan" ,"Kashmir" , "Murree" , "Rawalpindi" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loclist);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.listoflocations);
        autoCompleteTextView.setAdapter(adapter);

        Button gotomain =findViewById(R.id.Finish);

        gotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gomain = new Intent(chooselocation.this,Login.class);
                startActivity(gomain);
                finish();


            }
        });


    }
}