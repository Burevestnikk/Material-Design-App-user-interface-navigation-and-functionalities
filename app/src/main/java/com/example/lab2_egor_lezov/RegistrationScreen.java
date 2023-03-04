package com.example.lab2_egor_lezov;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationScreen extends AppCompatActivity {

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        if (!isConnected()) {
            startActivity(new Intent(RegistrationScreen.this, ErrorMessagesInternet.class));
        }
    }

    public void goLoginFromRegistrationScreen(View view) {
        startActivity(new Intent(RegistrationScreen.this, LoginScreen.class));
    }
    public void goBrowsingScreen(View view) {
        TextView username1 = findViewById(R.id.editRegistrationTextEmailAddress);
        TextView password1 = findViewById(R.id.editRegistrationTextPassword);
        if(username1.getText().toString().length() > 0 && password1.getText().toString().length() > 0) {
            if (!isConnected()) {
                startActivity(new Intent(RegistrationScreen.this, ErrorMessagesInternet.class));
            }else{
                if(username1.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "This account is already occupied!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "The account has been successfully created!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegistrationScreen.this, BrowsingScreen.class));
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "You have not filled in the data!", Toast.LENGTH_LONG).show();
        }
    }
}