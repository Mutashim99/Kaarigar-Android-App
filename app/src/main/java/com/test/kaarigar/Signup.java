package com.test.kaarigar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView alreadyacc = findViewById(R.id.alreadyacc);
        alreadyacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ialreadyacc = new Intent(Signup.this,Login.class);
                startActivity(ialreadyacc);
                finish();
            }
        });

        Button signup = findViewById(R.id.createaccount);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotolocation = new Intent(Signup.this,chooselocation.class);
                startActivity(gotolocation);

            }
        });


    }
}