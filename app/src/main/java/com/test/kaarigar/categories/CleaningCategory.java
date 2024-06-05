package com.test.kaarigar.categories;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.kaarigar.Login;
import com.test.kaarigar.Onboarding;
import com.test.kaarigar.R;
import com.test.kaarigar.Signup;
import com.test.kaarigar.categories.categoryAdapter;
import com.test.kaarigar.categories.categorymodel;
import com.test.kaarigar.chooselocation;
import com.test.kaarigar.detailpage.Cldetails1;
import com.test.kaarigar.detailpage.Cldetails2;
import com.test.kaarigar.detailpage.Cldetails3;
import com.test.kaarigar.detailpage.Cldetails4;

import java.util.ArrayList;
import java.util.List;

public class CleaningCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoryAdapter cardAdapter;
    private List<categorymodel> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cleaning_category);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.CleaningRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        // Add data to cardItemList with the target activities
        cardItemList.add(new categorymodel(R.drawable.pop1, "(4.5)", "Home Cleaning", "Rs 1500", Cldetails1.class));
        cardItemList.add(new categorymodel(R.drawable.pop2, "(4.0)", "Home DisInfection", "Rs 2000", Cldetails2.class));
        cardItemList.add(new categorymodel(R.drawable.car, "(4.7)", "Car Cleaning", "Rs 1000", Cldetails3.class));
        cardItemList.add(new categorymodel(R.drawable.sofa, "(4.2)", "Sofa Cleaning", "Rs 1800", Cldetails4.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(CleaningCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
