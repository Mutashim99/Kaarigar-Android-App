package com.test.kaarigar.categories;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.kaarigar.MainActivity;
import com.test.kaarigar.R;
import com.test.kaarigar.Signup;
import com.test.kaarigar.categories.categoryAdapter;
import com.test.kaarigar.categories.categorymodel;
import com.test.kaarigar.chooselocation;
import com.test.kaarigar.detailpage.APdetails1;
import com.test.kaarigar.detailpage.APdetails2;
import com.test.kaarigar.detailpage.APdetails3;
import com.test.kaarigar.detailpage.APdetails4;

import java.util.ArrayList;
import java.util.List;

public class AppliancesCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoryAdapter cardAdapter;
    private List<categorymodel> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appliances_category);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.AppliancesRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        // Add data to cardItemList with the target activities
        cardItemList.add(new categorymodel(R.drawable.washing_machine, "(4.5)", "Washing Machine \nRepair", "Rs 1500", APdetails1.class));
        cardItemList.add(new categorymodel(R.drawable.refrigirator, "(4.0)", "Refrigerator \nRepair", "Rs 2000", APdetails2.class));
        cardItemList.add(new categorymodel(R.drawable.microwave, "(4.7)", "Microwave \nRepair", "Rs 1000", APdetails3.class));
        cardItemList.add(new categorymodel(R.drawable.oven, "(4.2)", "Oven \nRepair", "Rs 1800", APdetails4.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(AppliancesCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
