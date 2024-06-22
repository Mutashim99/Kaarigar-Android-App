package com.test.kaarigar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class chooselocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooselocation);

        String[] loclist = {"Karachi", "Islamabad", "Lahore", "Peshawar", "Quetta", "Balochistan", "Kashmir", "Murree", "Rawalpindi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loclist);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.listoflocations);
        autoCompleteTextView.setAdapter(adapter);

        Button gotomain = findViewById(R.id.Finish);

        gotomain.setOnClickListener(v -> {
            String selectedLocation = autoCompleteTextView.getText().toString();
            if (!selectedLocation.isEmpty()) {
                // Save the selected location using SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("location", selectedLocation);
                editor.apply();

                // Redirect to the login activity
                Intent gomain = new Intent(chooselocation.this, Login.class);
                startActivity(gomain);
                finish();
            } else {
                Toast.makeText(chooselocation.this, "Please select a location", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
