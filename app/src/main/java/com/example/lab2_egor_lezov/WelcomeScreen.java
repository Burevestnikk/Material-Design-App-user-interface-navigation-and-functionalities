package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

    }
    public void goLoginScreen(View view) {
        System.out.println("welcomeLogin");
        startActivity(new Intent(WelcomeScreen.this, LoginScreen.class));
    }
    public void goDiscord(View view) {
        String url = "https://discord.gg/g29v9nSKUE"; // Replace with your URL
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}