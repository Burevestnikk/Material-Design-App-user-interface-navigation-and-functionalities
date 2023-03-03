package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

//    do{
//        //get some input.
//        //if the input meets my conditions, break;
//        //Otherwise ask again.
//    } while(true)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        if (!isConnected()) {
            startActivity(new Intent(WelcomeScreen.this, ErrorMessagesInternet.class));
        }
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