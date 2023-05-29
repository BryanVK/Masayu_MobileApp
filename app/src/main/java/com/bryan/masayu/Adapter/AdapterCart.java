package com.bryan.masayu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.masayu.Cart;
import com.bryan.masayu.Category;
import com.bryan.masayu.Food;
import com.bryan.masayu.R;
import com.google.android.material.transition.Hold;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.CartViewHolder> {
    ArrayList<Cart> carts;
    ArrayList<Food> foods;
    Context context;

    public AdapterCart(Context context, ArrayList<Cart> carts, ArrayList<Food> foods){
        this.context = context;
        this.carts = carts;
        this.foods = foods;
    }

    public AdapterCart(){

    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodlist, parent, false);
        return new AdapterCart.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = carts.get(position);
        holder.TvNama.setText(foods.get(cart.getFoodId()-1).getNameFood());
        holder.TvPrice.setText(String.valueOf(foods.get(cart.getFoodId()-1).getPrice()));
        Picasso.get().load(foods.get(cart.getFoodId()-1).getImage()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView TvNama, TvPrice, TvDistance;
        ImageView image;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            TvNama = itemView.findViewById(R.id.food_name);
            image = itemView.findViewById(R.id.food_item);
            TvPrice = itemView.findViewById(R.id.food_price);
            TvDistance = itemView.findViewById(R.id.food_distance);
        }
    }
}
