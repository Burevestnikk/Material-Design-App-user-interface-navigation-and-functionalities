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

public class LoginScreen extends AppCompatActivity {

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        if (!isConnected()) {
            startActivity(new Intent(LoginScreen.this, ErrorMessagesInternet.class));
        }
    }

    public void goRegistrationScreen(View view) {
        startActivity(new Intent(LoginScreen.this, RegistrationScreen.class));
    }
    public void goBrowsingScreenLogin(View view) {
        TextView username = findViewById(R.id.editRegistrationTextEmailAddress);
        TextView password = findViewById(R.id.editRegistrationTextPassword);
            if(username.getText().toString().length() > 2 && password.getText().toString().length() > 2){
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    if(!isConnected()){
                        startActivity(new Intent(LoginScreen.this, ErrorMessagesInternet.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Successfully!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginScreen.this, BrowsingScreen.class));
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login error!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "You have not filled in the data!", Toast.LENGTH_LONG).show();
            }
    }
    public void goForgotPasswordScreen(View view) {
        startActivity(new Intent(LoginScreen.this, ForgotPasswordScreen.class));
    }
    public void goGoogleLogin(View view) {
        Toast.makeText(getApplicationContext(), "Redirecting to the login page...", Toast.LENGTH_LONG).show();
    }
}