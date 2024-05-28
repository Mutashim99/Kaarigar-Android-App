package com.test.kaarigar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handling window insets specifically for SearchView
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.searchView), (view, insets) -> {
            WindowInsetsCompat insetsCompat = insets;
            int topInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            view.setPadding(view.getPaddingLeft(), topInset, view.getPaddingRight(), view.getPaddingBottom());
            return insets;
        });

        // Set BottomNavigationView height if necessary
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        int bottomNavHeight = getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height);
        bottomNavigationView.getLayoutParams().height = bottomNavHeight;
        bottomNavigationView.requestLayout();

        // Setup image slider
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner5, ScaleTypes.FIT));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.pop1, "Home \nCleaning", "5.0", "Rs 1000"));
        cardItemList.add(new CardItem(R.drawable.pop2, "Home \nDisInfection", "4.5", "Rs 2000"));
        cardItemList.add(new CardItem(R.drawable.pop3, "Ac \nCheckup", "4.8", "Rs 1500"));
        cardItemList.add(new CardItem(R.drawable.pop4, "Ac \nRepair", "4.2", "Rs 5000"));
        cardItemList.add(new CardItem(R.drawable.pop5, "Ac \nMaintenance", "4.2", "Rs 1800"));

        CardAdapter cardAdapter = new CardAdapter(cardItemList);
        recyclerView.setAdapter(cardAdapter);
    }
}
