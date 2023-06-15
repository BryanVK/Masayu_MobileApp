package com.bryan.masayu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bryan.masayu.Activity.LoginActivity;
import com.bryan.masayu.Activity.MainActivity;
import com.bryan.masayu.Activity.OrderActivity;
import com.bryan.masayu.Activity.SignupActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity {

    private GoogleMap map;
    private final Double LAT = -6.20201;
    private final Double LONG = 106.78113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gmaps);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                map = googleMap;

                LatLng location = new LatLng(LAT, LONG);
                map.addMarker(new MarkerOptions()
                        .position(location));
                map.moveCamera(CameraUpdateFactory.newLatLng(location));
            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_back) {
            Intent MoveIntent3 = new Intent(MapsActivity.this, OrderActivity.class);
            startActivity(MoveIntent3);
        }
    }
}