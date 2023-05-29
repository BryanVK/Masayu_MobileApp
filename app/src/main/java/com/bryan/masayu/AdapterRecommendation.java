package com.bryan.masayu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecommendation extends RecyclerView.Adapter<AdapterRecommendation.recomendationViewHolder>{
    ArrayList<Recomendation> recomenArrayList;

    public AdapterRecommendation(ArrayList<Recomendation> recomenArrayList) {
        this.recomenArrayList = recomenArrayList;
    }

    public AdapterRecommendation() {

    }

    @NonNull
    @Override
    public recomendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new recomendationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecommendation.recomendationViewHolder holder, int position) {

        final Recomendation recomendation = recomenArrayList.get(position);
        holder.TvNama.setText(recomendation.getName());
        holder.price.setText(recomendation.getPrice());
        holder.image.setImageResource(recomendation.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return recomenArrayList.size();
    }

    public class recomendationViewHolder extends RecyclerView.ViewHolder {
        TextView TvNama, price;
        ImageView image;
        public recomendationViewHolder(@NonNull View itemView) {
            super(itemView);
            TvNama = itemView.findViewById(R.id.recomended_name);
            image = itemView.findViewById(R.id.recomendation_item);
            price = itemView.findViewById(R.id.recomended_price);
        }
    }
}
