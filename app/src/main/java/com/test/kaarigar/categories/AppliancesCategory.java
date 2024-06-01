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
        cardItemList.add(new categorymodel(R.drawable.pop1, "(4.5)", "Washing Machine \nRepair", "Rs 1500", Notification.class));
        cardItemList.add(new categorymodel(R.drawable.pop2, "(4.0)", "Refrigerator \nRepair", "Rs 2000", MainActivity.class));
        cardItemList.add(new categorymodel(R.drawable.pop3, "(4.7)", "Microwave \nRepair", "Rs 1000", Signup.class));
        cardItemList.add(new categorymodel(R.drawable.pop4, "(4.2)", "Oven \nRepair", "Rs 1800", chooselocation.class));
        // Add more items as needed

        cardAdapter = new categoryAdapter(cardItemList, item -> {
            Intent intent = new Intent(AppliancesCategory.this, item.getTargetActivity());
            startActivity(intent);
        });
        recyclerView.setAdapter(cardAdapter);
    }
}
