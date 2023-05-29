package com.bryan.masayu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.categoryViewHolder> {

    ArrayList<Category> categoryArrayList;

    public AdapterCategory(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    public AdapterCategory() {

    }


    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategory.categoryViewHolder holder, int position) {

        final Category category = categoryArrayList.get(position);
        holder.TvNama.setText(category.getNamaKategori());
        holder.image.setImageResource(category.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        TextView TvNama;
        ImageView image;
        public categoryViewHolder(@NonNull View itemView) {

            super(itemView);
            TvNama = itemView.findViewById(R.id.category_name);
            image = itemView.findViewById(R.id.category_item);
        }
    }
}
