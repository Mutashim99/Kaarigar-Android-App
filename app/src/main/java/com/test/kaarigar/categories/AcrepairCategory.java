package com.test.kaarigar.categories;

import android.content.Intent;
import android.os.Bundle;
import android.window.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.kaarigar.Login;
import com.test.kaarigar.MainActivity;
import com.test.kaarigar.R;
import com.test.kaarigar.Signup;
import com.test.kaarigar.categories.categoryAdapter;
import com.test.kaarigar.categories.categorymodel;
import com.test.kaarigar.detailpage.AcDetails1;

import java.util.ArrayList;
import java.util.List;

public class AcrepairCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoryAdapter cardAdapter;
    private List<categorymodel> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acrepair_category);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.ACrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        // Add data to cardItemList with the target activities
        cardItemList.add(new categorymodel(R.drawable.accat1, "(4.8)", "AC Repair", "Rs 5999", AcDetails1.class));
        cardItemList.add(new categorymodel(R.drawable.accat2, "(4.2)", "AC Duct Cleaning", "Rs3999", Signup.class));
        cardItemList.add(new categorymodel(R.drawable.pop4, "(4.5)", "AC Routine Repair", "Rs 2000", Login.class));
        cardItemList.add(new categorymodel(R.drawable.pop5, "(3.9)", "AC Installation", "Rs 1999", MainActivity.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(AcrepairCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
