package com.bryan.masayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView btnSignup;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MoveIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(MoveIntent);
            }
        });

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup) {
            Intent MoveIntent2 = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(MoveIntent2);
        } else if (v.getId() == R.id.btn_back) {
            Intent MoveIntent3 = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(MoveIntent3);
        }
    }


}