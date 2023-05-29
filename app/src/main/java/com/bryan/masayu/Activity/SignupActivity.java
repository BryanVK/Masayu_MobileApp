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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    TextView btnLogin;
    Button btnSignup;
    ImageView btnBack;

    HelperDatabase helper;
    EditText edtUsername, edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        helper = new HelperDatabase(this);

        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnSignup.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty() || username.isEmpty()){
                Toast.makeText(SignupActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            } else {
                Boolean check = helper.checkEmail(email);
                if(check){
                    Toast.makeText(this, "Email already taken", Toast.LENGTH_SHORT).show();
                }
                else {
                    helper.insertData(email,username, password);
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    Intent MoveIntent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(MoveIntent);
                }

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