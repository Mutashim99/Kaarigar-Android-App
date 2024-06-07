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
import com.test.kaarigar.detailpage.Shftdetails1;
import com.test.kaarigar.detailpage.Shftdetails2;
import com.test.kaarigar.detailpage.Shftdetails3;
import com.test.kaarigar.detailpage.Shftdetails4;

import java.util.ArrayList;
import java.util.List;

public class ShiftingCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoryAdapter cardAdapter;
    private List<categorymodel> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shifting_category);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.ShiftingRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        // Add data to cardItemList with the target activities
        cardItemList.add(new categorymodel(R.drawable.house_shifting, "(4.5)", "House Shifting", "Rs 1500", Shftdetails1.class));
        cardItemList.add(new categorymodel(R.drawable.office_shifting, "(4.0)", "Office Shifting", "Rs 2000", Shftdetails2.class));
        cardItemList.add(new categorymodel(R.drawable.warehouse_shifting, "(4.7)", "Warehouse Shifting", "Rs 1000", Shftdetails3.class));
        cardItemList.add(new categorymodel(R.drawable.furniture_shifting, "(4.2)", "Furniture Shifting", "Rs 1800", Shftdetails4.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(ShiftingCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
