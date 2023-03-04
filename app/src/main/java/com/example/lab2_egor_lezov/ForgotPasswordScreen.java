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

public class ForgotPasswordScreen extends AppCompatActivity {

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        if (!isConnected()) {
            startActivity(new Intent(ForgotPasswordScreen.this, ErrorMessagesInternet.class));
        }
    }

    public void goWelcomeScreen(View view) {
        TextView username = findViewById(R.id.editRegistrationTextEmailAddress3);
        if(username.getText().toString().length() > 2){
            if(!isConnected()){
                startActivity(new Intent(ForgotPasswordScreen.this, ErrorMessagesInternet.class));
            }else{
                Toast.makeText(getApplicationContext(), "The code has been sent to the specified email address!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ForgotPasswordScreen.this, WelcomeScreen.class));
            }
        }else{
            Toast.makeText(getApplicationContext(), "You have not filled in the data!", Toast.LENGTH_LONG).show();
        }
    }
}