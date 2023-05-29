package com.bryan.masayu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.masayu.Activity.DetailFoodActivity;
import com.bryan.masayu.Food;
import com.bryan.masayu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.FoodViewHolder> {
    ArrayList<Food> foodArrayList;
    Context context;
    public OnFoodClickListener onFoodClickListener;

    public interface OnFoodClickListener{
        void onFoodClick(int position, Food food);
    }

    public void setOnFoodClickListener(OnFoodClickListener onFoodClickListener){
        this.onFoodClickListener = onFoodClickListener;
    }
    public AdapterFood(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    public AdapterFood() {

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodlist, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodArrayList.get(position);
        holder.TvNama.setText(food.getNameFood());
        holder.TvPrice.setText(String.valueOf(food.getPrice()));
        Picasso.get().load(food.getImage()).into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            if (onFoodClickListener != null){
                onFoodClickListener.onFoodClick(holder.getAdapterPosition(), food);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView TvNama, TvPrice, TvDistance;
        ImageView image;
        public FoodViewHolder(@NonNull View itemView) {

            super(itemView);
            TvNama = itemView.findViewById(R.id.food_name);
            image = itemView.findViewById(R.id.food_item);
            TvPrice = itemView.findViewById(R.id.food_price);
            TvDistance = itemView.findViewById(R.id.food_distance);
        }
    }
}
