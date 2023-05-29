package com.bryan.masayu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import com.bryan.masayu.Fragment.HomeFragment;
import com.bryan.masayu.Fragment.SearchFragment;
import com.bryan.masayu.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView buttonNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();

    private String email;

//    ArrayList<Category> objNews = new ArrayList<>();
//
//    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        buttonNavigationView = findViewById(R.id.menuNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer, homeFragment).commit();

        email = getIntent().getStringExtra("email");
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        homeFragment.setArguments(bundle);
        Log.i("EMAIL", "onHOME: "+ email);

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
                        homeFragment.setArguments(bundle);

                        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer,homeFragment ).commit();
                        break;

                    case R.id.store:
                        Intent MoveIntent = new Intent(HomeActivity.this, OrderActivity.class);
                        MoveIntent.putExtra("userEmail", email);
                        startActivity(MoveIntent);
                        break;

                    case R.id.search:
                        searchFragment.setArguments(bundle);

                        getSupportFragmentManager().beginTransaction().replace(R.id.navContainer, searchFragment).commit();
                        break;

                }

                return true;
            }
        });


    }



}
