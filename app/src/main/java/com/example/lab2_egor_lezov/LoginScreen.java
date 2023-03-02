package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public void goRegistrationScreen(View view) {
        System.out.println("goRegistrationScreen");
        startActivity(new Intent(LoginScreen.this, RegistrationScreen.class));
    }
    public void goBrowsingScreen(View view) {
        System.out.println("goBrowsingScreen");
        startActivity(new Intent(LoginScreen.this, WelcomeScreen.class));
    }
}