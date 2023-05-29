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

public class SearchFragment extends Fragment {

    ArrayList<Category> objNews = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvCategory);
        recyclerView.setHasFixedSize(true);
        objNews.addAll(getListCategory());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterCategory adapterCategory = new AdapterCategory(objNews);
        recyclerView.setAdapter(adapterCategory);

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
}