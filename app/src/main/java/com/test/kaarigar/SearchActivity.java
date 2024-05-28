package com.test.kaarigar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_acivity);

        // Initialize views
        searchView = findViewById(R.id.searchViewnew);
        listView = findViewById(R.id.listview);

        listView.setVisibility(View.GONE);

        // Populate the list with data
        arrayList = new ArrayList<>();
        arrayList.add("Plumber");
        arrayList.add("Electrician");
        arrayList.add("Painter");
        arrayList.add("Cleaning");
        arrayList.add("Home Repair");
        arrayList.add("Facial");
        arrayList.add("Severage");
        arrayList.add("Loading");
        arrayList.add("Shifting");
        arrayList.add("Sink");
        arrayList.add("Ac Repair");

        // Set up the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        // Set up the search view listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(searchView.findFocus(), InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
