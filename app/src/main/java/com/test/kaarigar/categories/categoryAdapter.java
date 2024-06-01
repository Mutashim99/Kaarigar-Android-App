package com.test.kaarigar.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.kaarigar.R;
import com.test.kaarigar.categories.categorymodel;

import java.util.List;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {

    private List<categorymodel> itemList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(categorymodel item);
    }

    public categoryAdapter(List<categorymodel> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoryitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        categorymodel item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.ratingView.setText(item.getRating());
        holder.descriptionView.setText(item.getDescription());
        holder.priceView.setText(item.getPrice());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView ratingView;
        TextView descriptionView;
        TextView priceView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView14);
            ratingView = itemView.findViewById(R.id.textView27);
            descriptionView = itemView.findViewById(R.id.textView28);
            priceView = itemView.findViewById(R.id.textView29);
        }
    }
}
