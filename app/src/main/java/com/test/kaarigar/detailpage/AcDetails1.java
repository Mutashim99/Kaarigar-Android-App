package com.test.kaarigar.detailpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.test.kaarigar.ConfirmBooking;
import com.test.kaarigar.R;

public class AcDetails1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ac_details1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView foregroundCardView = findViewById(R.id.frontcard);
        foregroundCardView.bringToFront();

        Button gonextact = findViewById(R.id.booknow);

        gonextact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goproceed = new Intent(AcDetails1.this , ConfirmBooking.class);
                startActivity(goproceed);
            }
        });

    }
}