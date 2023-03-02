package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
    }

    public void goLoginFromRegistrationScreen(View view) {
        System.out.println("goLoginFromRegistrationScreen");
        startActivity(new Intent(RegistrationScreen.this, LoginScreen.class));
    }
    public void goBrowsingScreen(View view) {
        System.out.println("goBrowsingScreen");
        startActivity(new Intent(RegistrationScreen.this, WelcomeScreen.class));
    }
}