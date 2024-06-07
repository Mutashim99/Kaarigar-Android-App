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
import com.test.kaarigar.detailpage.Pntdetails1;
import com.test.kaarigar.detailpage.Pntdetails2;
import com.test.kaarigar.detailpage.Pntdetails3;
import com.test.kaarigar.detailpage.Pntdetails4;

import java.util.ArrayList;
import java.util.List;

public class PaintingCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoryAdapter cardAdapter;
    private List<categorymodel> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_painting_category);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.PaintingRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        // Add data to cardItemList with the target activities
        cardItemList.add(new categorymodel(R.drawable.interior, "(4.5)", "Interior Painting", "Rs 15000", Pntdetails1.class));
        cardItemList.add(new categorymodel(R.drawable.exterior, "(4.0)", "Exterior Painting", "Rs 20000", Pntdetails2.class));
        cardItemList.add(new categorymodel(R.drawable.wallpaper, "(4.7)", "Wallpaper Vinyl", "Rs 10000", Pntdetails3.class));
        cardItemList.add(new categorymodel(R.drawable.ceiling, "(4.2)", "Ceiling Painting", "Rs 18000", Pntdetails4.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(PaintingCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
