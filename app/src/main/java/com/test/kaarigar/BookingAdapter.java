package com.test.kaarigar;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    private List<Booking> bookingList;
    private Context context;
    private String pendingCallNumber;

    public BookingAdapter(List<Booking> bookingList, Context context) {
        this.bookingList = bookingList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookingList.get(position);
        holder.bookingName.setText(booking.getName());
        holder.bookingPrice.setText(booking.getPrice());
        holder.bookingImage.setImageResource(booking.getImageResId());

        holder.callButton.setOnClickListener(v -> {
            String phoneNumber = booking.getPhoneNumber();
            makeCall(phoneNumber);
        });

        holder.cancelButton.setOnClickListener(v -> {
            showConfirmationDialog(position);
        });
    }

    private void showConfirmationDialog(int position) {
        new AlertDialog.Builder(context)
                .setTitle("Cancel Booking")
                .setMessage("Are you sure you want to cancel this booking?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    bookingList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, bookingList.size());
                    saveBookings();
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    private void makeCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            pendingCallNumber = phoneNumber;
            ActivityCompat.requestPermissions((FragmentActivity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return;
        }
        context.startActivity(callIntent);
    }

    public void makePendingCall() {
        if (pendingCallNumber != null) {
            makeCall(pendingCallNumber);
            pendingCallNumber = null;
        }
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView bookingName, bookingPrice;
        ImageView bookingImage;
        Button callButton, cancelButton;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            bookingName = itemView.findViewById(R.id.bookingname);
            bookingPrice = itemView.findViewById(R.id.bookingprice);
            bookingImage = itemView.findViewById(R.id.bookimg);
            callButton = itemView.findViewById(R.id.callbutt);
            cancelButton = itemView.findViewById(R.id.cancelbutt);
        }
    }

    private void saveBookings() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("bookings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookingList);
        editor.putString("bookingList", json);
        editor.apply();
    }
}
