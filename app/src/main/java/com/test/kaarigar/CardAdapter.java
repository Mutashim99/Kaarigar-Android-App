package com.test.kaarigar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardItem> cardItemList;
    private OnItemClickListener listener;

    public CardAdapter(List<CardItem> cardItemList, OnItemClickListener listener) {
        this.cardItemList = cardItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popularitem, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        holder.imageView.setImageResource(cardItem.getImageResource());
        holder.serviceName.setText(cardItem.getServiceName());
        holder.rating.setText(cardItem.getRating());
        holder.price.setText(cardItem.getPrice());
        holder.bind(position, listener);
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, ratingIcon;
        TextView serviceName, rating, price;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.popimg);
            serviceName = itemView.findViewById(R.id.textView21);
            ratingIcon = itemView.findViewById(R.id.imageView23);
            rating = itemView.findViewById(R.id.textView22);
            price = itemView.findViewById(R.id.paisa);
        }

        public void bind(final int position, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
        }
    }
}
