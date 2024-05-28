package com.test.kaarigar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        EditText username = findViewById(R.id.usernamesign);
        EditText email = findViewById(R.id.emailsign);
        EditText password = findViewById(R.id.passsign);

        TextView alreadyacc = findViewById(R.id.alreadyacc);
        alreadyacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ialreadyacc = new Intent(Signup.this, Login.class);
                startActivity(ialreadyacc);
                finish();
            }
        });

        Button signup = findViewById(R.id.createaccount);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();

                if (usernameValue.isEmpty() || emailValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText(Signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Save the user data using SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("email", emailValue);
                    editor.putString("password", passwordValue);
                    editor.apply();

                    // Redirect to the login activity
                    Intent intent = new Intent(Signup.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
