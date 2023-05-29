package com.bryan.masayu.Fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.masayu.Activity.DetailFoodActivity;
import com.bryan.masayu.Adapter.AdapterFood;
import com.bryan.masayu.Adapter.AdapterCategory;
import com.bryan.masayu.Category;
import com.bryan.masayu.Database.HelperDatabase;
import com.bryan.masayu.Food;
import com.bryan.masayu.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {


    ArrayList<Category> objNews = new ArrayList<>();
    ArrayList<Food> objFood = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView recyclerView2;

    HelperDatabase helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        String email = bundle.getString("email");

        helper = new HelperDatabase(getContext());

        recyclerView = view.findViewById(R.id.rvCategory);
        recyclerView.setHasFixedSize(true);
        objNews.addAll(getListCategory());

        recyclerView2 = view.findViewById(R.id.rvFood);
        recyclerView2.setHasFixedSize(true);
        objFood = helper.getAllFoods();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterCategory adapterCategory = new AdapterCategory(getContext(), objNews);
        recyclerView.setAdapter(adapterCategory);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterFood adapterFood = new AdapterFood(getContext(), objFood);
        recyclerView2.setAdapter(adapterFood);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setHasFixedSize(true);

        adapterFood.setOnFoodClickListener(new AdapterFood.OnFoodClickListener() {
            @Override
            public void onFoodClick(int position, Food food) {
                Intent intent = new Intent(getContext(), DetailFoodActivity.class);
                intent.putExtra("name", food.getNameFood());
                intent.putExtra("price", String.valueOf(food.getPrice()));
                intent.putExtra("image", food.getImage());
                intent.putExtra("description", food.getDescription());
                intent.putExtra("ingredient", food.getIngredients());
                intent.putExtra("step", food.getStep());
                intent.putExtra("user", email);
                startActivity(intent);
            }
        });


    }

    public ArrayList<Category> getListCategory(){
        String[] name = getResources().getStringArray(R.array.data_categoryName);
        TypedArray photo = getResources().obtainTypedArray(R.array.data_categoryImg);

        ArrayList<Category> listCategory = new ArrayList<>();

        for(int i = 0; i<name.length; i++){
            Category news = new Category();
            news.setNamaKategori(name[i]);
            news.setImage(photo.getResourceId(i,-1));
            listCategory.add(news);
        }
        return listCategory;
    }


}