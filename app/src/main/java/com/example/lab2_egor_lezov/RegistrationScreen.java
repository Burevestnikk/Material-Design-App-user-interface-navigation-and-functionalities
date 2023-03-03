package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
    }

    WelcomeScreen myInstance = new WelcomeScreen();

    public void goLoginFromRegistrationScreen(View view) {
        startActivity(new Intent(RegistrationScreen.this, LoginScreen.class));
    }
    public void goBrowsingScreen(View view) {
        TextView username1 = findViewById(R.id.editRegistrationTextEmailAddress);
        TextView password1 = findViewById(R.id.editRegistrationTextPassword);
        if(username1.getText().toString().length() > 0 && password1.getText().toString().length() > 0) {
            if (!myInstance.isConnected()) {
                startActivity(new Intent(RegistrationScreen.this, ErrorMessagesInternet.class));
            }else{
                startActivity(new Intent(RegistrationScreen.this, LoginScreen.class));
            }
        }else{
            //уведомление сюда
            System.out.println("УВЕДОМЛЕНИЕ НЕТ ДАННЫЕ РЕГ!");
        }
    }
}