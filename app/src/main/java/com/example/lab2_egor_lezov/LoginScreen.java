package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }
    WelcomeScreen myInstances = new WelcomeScreen();

    public void goRegistrationScreen(View view) {
        startActivity(new Intent(LoginScreen.this, BrowsingScreen.class));//startActivity(new Intent(LoginScreen.this, RegistrationScreen.class));
    }
    public void goBrowsingScreen(View view) {
        TextView username = findViewById(R.id.editRegistrationTextEmailAddress);
        TextView password = findViewById(R.id.editRegistrationTextPassword);
            if(username.getText().toString().length() > 2 && password.getText().toString().length() > 2){
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    if(!myInstances.isConnected()){
                        startActivity(new Intent(LoginScreen.this, ErrorMessagesInternet.class));
                    }else{
                        startActivity(new Intent(LoginScreen.this, BrowsingScreen.class));
                        System.out.println("LFFFFFFFFFFFFFFFFFFFFFFFFFF");
                    }
                }
            }else{
                //уведомление сюда
                System.out.println("УВЕДОМЛЕНИЕ ДАННЫЕ ЛОГИН!");
            }
    }
}