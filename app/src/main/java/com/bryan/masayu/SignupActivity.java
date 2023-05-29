package com.bryan.masayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    TextView btnLogin;
    Button btnSignup;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MoveIntent = new Intent(SignupActivity.this, SignupActivity.class);
                startActivity(MoveIntent);
            }
        });

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            Intent MoveIntent2 = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(MoveIntent2);
        }else if (v.getId() == R.id.btn_back) {
            Intent MoveIntent3 = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(MoveIntent3);
        }
    }
}