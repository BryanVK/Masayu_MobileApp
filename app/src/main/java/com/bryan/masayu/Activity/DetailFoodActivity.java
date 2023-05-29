package com.bryan.masayu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bryan.masayu.Database.HelperDatabase;
import com.bryan.masayu.Food;
import com.bryan.masayu.Fragment.SearchFragment;
import com.bryan.masayu.R;
import com.squareup.picasso.Picasso;

public class DetailFoodActivity extends AppCompatActivity {

    ImageView btnBack;
    TextView tvName, tvPrice, desc, ingredient, howToCook;
    ImageView image;

    Button addToCart;

    HelperDatabase helper;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        addToCart = findViewById(R.id.btnAddCart);
        helper = new HelperDatabase(this);

        tvName = findViewById(R.id.name_food);
        tvName.setText(getIntent().getStringExtra("name"));

        tvPrice = findViewById(R.id.price_food);
        tvPrice.setText(getIntent().getStringExtra("price"));

        desc = findViewById(R.id.descContent);
        desc.setText(getIntent().getStringExtra("description"));

        howToCook = findViewById(R.id.stepsContent);
        howToCook.setText(getIntent().getStringExtra("step"));

        ingredient = findViewById(R.id.ingContent);
        ingredient.setText(getIntent().getStringExtra("ingredient"));

        image = findViewById(R.id.img_food);
        Picasso.get().load(getIntent().getStringExtra("image")).into(image);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            Intent MoveIntent = new Intent(DetailFoodActivity.this, HomeActivity.class);
            startActivity(MoveIntent);
        });

        addToCart.setOnClickListener(v -> {
            Integer foodId = helper.getFoodId(getIntent().getStringExtra("name"));
            email = getIntent().getStringExtra("user");
            Boolean insert = helper.insertCart(foodId, email);
            if (insert){
                Toast.makeText(this, "Successfully add to cart", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DetailFoodActivity.this, HomeActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this, "Failed add to cart", Toast.LENGTH_SHORT).show();
            }
        });

    }
}