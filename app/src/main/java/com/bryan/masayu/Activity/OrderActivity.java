package com.bryan.masayu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bryan.masayu.Adapter.AdapterCart;
import com.bryan.masayu.Cart;
import com.bryan.masayu.Database.HelperDatabase;
import com.bryan.masayu.Food;
import com.bryan.masayu.MapsActivity;
import com.bryan.masayu.R;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ImageView btnBack;
    Button btnLocation, btnOrder;

    ArrayList<Food> foods;
    ArrayList<Cart> carts;
    HelperDatabase helper;

    RecyclerView rvCart;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        rvCart = findViewById(R.id.rvCart);

        helper = new HelperDatabase(this);
        foods = new ArrayList<>();
        foods = helper.getAllFoods();

        email = getIntent().getStringExtra("userEmail");
        Log.i("EMAIL", "onOrder "+ email);
        carts = new ArrayList<>();
        carts = helper.getAllCarts(email);

        AdapterCart adapterCart = new AdapterCart(this, carts, foods);
        rvCart.setAdapter(adapterCart);
        rvCart.setLayoutManager(new LinearLayoutManager(this));

        btnLocation = findViewById(R.id.edt_location);
        btnBack = findViewById(R.id.btn_back);
        btnOrder = findViewById(R.id.btn_order);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MoveIntent = new Intent(OrderActivity.this, HomeActivity.class);
                MoveIntent.putExtra("email", email);
                startActivity(MoveIntent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent MoveIntent2 = new Intent(OrderActivity.this, MapsActivity.class);
                startActivity(MoveIntent2);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(OrderActivity.this, "Order Successfully", Toast.LENGTH_SHORT).show();
                Intent MoveIntent3 = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(MoveIntent3);
            }
        });

    }
}