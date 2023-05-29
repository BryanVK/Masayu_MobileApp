package com.bryan.masayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView buttonNavigationView;
    HomeFragment blankFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();

//    ArrayList<Category> objNews = new ArrayList<>();
//
//    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        buttonNavigationView = findViewById(R.id.menuNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer, blankFragment).commit();

//        recyclerView = findViewById(R.id.rvCategory);
//        recyclerView.setHasFixedSize(true);
//        objNews.addAll(getListCategory());
//        showRecyclerList();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);


        buttonNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer,blankFragment ).commit();
                        break;

                    case R.id.store:
                        Intent MoveIntent = new Intent(HomeActivity.this, OrderActivity.class);
                        startActivity(MoveIntent);
                        break;

                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer, searchFragment).commit();
                        break;

                }

                return true;
            }
        });


    }

//    public ArrayList<Category> getListCategory(){
//        String[] name = getResources().getStringArray(R.array.data_categoryName);
//        TypedArray photo = getResources().obtainTypedArray(R.array.data_categoryImg);
//
//        ArrayList<Category> listCategory = new ArrayList<>();
//
//        for(int i = 0; i<name.length; i++){
//            Category news = new Category();
//            news.setNamaKategori(name[i]);
//            news.setImage(photo.getResourceId(i,-1));
//            listCategory.add(news);
//        }
//        return listCategory;
//    }
//
//    private void showRecyclerList(){
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        AdapterCategory adapterCategory = new AdapterCategory(objNews);
//        recyclerView.setAdapter(adapterCategory);
//
//    }



}
