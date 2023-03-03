package com.example.lab2_egor_lezov;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ErrorMessagesInternet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error_messages_internet);
    }

    WelcomeScreen myInstance = new WelcomeScreen();
    public void goWelcomeScreen(View view) {
        if (myInstance.isConnected()) {
            startActivity(new Intent(ErrorMessagesInternet.this, WelcomeScreen.class));
        }
    }
}