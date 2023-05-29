package com.bryan.masayu;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Category> objCat = new ArrayList<>();
    ArrayList<Recomendation> objRec = new ArrayList<>();

    RecyclerView recyclerView, recyclerView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvCategory);
        recyclerView.setHasFixedSize(true);
        objCat.addAll(getListCategory());

//        recyclerView2 = view.findViewById(R.id.rvRecomendation);
//        recyclerView2.setHasFixedSize(true);
//        objRec.addAll(getListRecomen());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterCategory adapterCategory = new AdapterCategory(objCat);
        recyclerView.setAdapter(adapterCategory);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        AdapterRecommendation adapterRecomendation = new AdapterRecommendation(objRec);
//        recyclerView.setAdapter(adapterRecomendation);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);



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
//
//    public ArrayList<Recomendation> getListRecomen(){
//        String[] name = getResources().getStringArray(R.array.data_RekomendationName);
//        int[] price = getResources().getIntArray(R.array.data_price);
//        TypedArray photo = getResources().obtainTypedArray(R.array.data_RecomendationImg);
//
//        ArrayList<Recomendation> listRecomendation = new ArrayList<>();
//
//        for(int i = 0; i<name.length; i++){
//            Recomendation recomendation = new Recomendation();
//            recomendation.setName(name[i]);
//            recomendation.setPrice(price[i]);
//            recomendation.setImage(photo.getResourceId(i,-1));
//            listRecomendation.add(recomendation);
//        }
//        return listRecomendation;
//    }

//    private void showRecyclerList(){
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        AdapterCategory adapterCategory = new AdapterCategory(objNews);
//        recyclerView.setAdapter(adapterCategory);
//
//    }
}