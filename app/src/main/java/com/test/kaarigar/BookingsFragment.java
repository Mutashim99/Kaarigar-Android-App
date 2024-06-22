package com.test.kaarigar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends Fragment {

    private static final int REQUEST_CALL_PERMISSION = 1;
    private RecyclerView bookingRecyclerView;
    private BookingAdapter bookingAdapter;
    private List<Booking> bookingList;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("bookings", Context.MODE_PRIVATE);
        gson = new Gson();
        // Load bookings from SharedPreferences
        loadBookings();
    }

    private void loadBookings() {
        String json = sharedPreferences.getString("bookingList", null);
        Type type = new TypeToken<ArrayList<Booking>>() {}.getType();
        bookingList = json == null ? new ArrayList<>() : gson.fromJson(json, type);

        // Temporary data for testing
        if (bookingList.isEmpty()) {
            bookingList.add(new Booking("Water Heater Repair", "Rs 18000", "0321346231", R.drawable.heater));
            bookingList.add(new Booking("Hair Styling", "Rs 2000", "0321654315", R.drawable.hair));
            bookingList.add(new Booking("Interior Painting", "Rs 15000", "0335435464", R.drawable.interior));
            bookingList.add(new Booking("Booking 1", "$200", "0363134354", R.drawable.leak));
            bookingList.add(new Booking("Booking 1", "$200", "0367654654", R.drawable.laptop));
            bookingList.add(new Booking("Booking 1", "$200", "0387654321", R.drawable.mobile));
            bookingList.add(new Booking("Booking 1", "$200", "0387654321", R.drawable.oven));
            bookingList.add(new Booking("Booking 1", "$200", "0387654321", R.drawable.exterior));
            bookingList.add(new Booking("Booking 1", "$200", "0387654321", R.drawable.sofa));

            saveBookings();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        bookingRecyclerView = view.findViewById(R.id.bookingRecyclerView);
        bookingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        bookingAdapter = new BookingAdapter(bookingList, getActivity());
        bookingRecyclerView.setAdapter(bookingAdapter);
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                bookingAdapter.makePendingCall();
            }
        }
    }

    private void saveBookings() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = gson.toJson(bookingList);
        editor.putString("bookingList", json);
        editor.apply();
    }
}
