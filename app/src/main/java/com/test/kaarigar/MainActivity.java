package com.test.kaarigar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
            NavigationUI.setupWithNavController(bottomNav, navController);
        }

        // Handling window insets specifically for SearchView
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.searchView), (view, insets) -> {
            WindowInsetsCompat insetsCompat = insets;
            int topInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            view.setPadding(view.getPaddingLeft(), topInset, view.getPaddingRight(), view.getPaddingBottom());
            return insets;
        });

        // Set BottomNavigationView height if necessary
        int bottomNavHeight = getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.getLayoutParams().height = bottomNavHeight;
        bottomNav.requestLayout();
    }
}
