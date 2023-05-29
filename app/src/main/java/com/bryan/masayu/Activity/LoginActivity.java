package com.bryan.masayu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bryan.masayu.Database.HelperDatabase;
import com.bryan.masayu.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView btnSignup;
    ImageView btnBack;

    EditText edtEmail, edtPassword;

    HelperDatabase helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new HelperDatabase(this);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(LoginActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            } else {

                Boolean check = helper.checkEmailPassword(email, password);
                if (check) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent MoveIntent = new Intent(LoginActivity.this, HomeActivity.class);
                    MoveIntent.putExtra("email", email);
                    startActivity(MoveIntent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
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