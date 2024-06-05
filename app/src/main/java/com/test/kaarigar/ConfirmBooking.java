package com.test.kaarigar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmBooking extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private EditText editTextDate;
    private Button bookingDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirm_booking);

        editTextName = findViewById(R.id.editTextText);
        editTextAddress = findViewById(R.id.editTextText2);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextDate = findViewById(R.id.editTextDate);
        bookingDoneButton = findViewById(R.id.bookingdone);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bookingDoneButton.setOnClickListener(view -> {
            if (areAllFieldsFilled()) {
                showConfirmationPopup();
            } else {
                showErrorPopup();
            }
        });
    }

    private boolean areAllFieldsFilled() {
        return !TextUtils.isEmpty(editTextName.getText().toString()) &&
                !TextUtils.isEmpty(editTextAddress.getText().toString()) &&
                !TextUtils.isEmpty(editTextPhone.getText().toString()) &&
                !TextUtils.isEmpty(editTextDate.getText().toString());
    }

    private void showConfirmationPopup() {
        new AlertDialog.Builder(this)
                .setTitle("Booking Confirmed")
                .setMessage("Your booking has been confirmed!")
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    goToHomePage();
                })
                .show();
    }

    private void showErrorPopup() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Please fill all the fields.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
