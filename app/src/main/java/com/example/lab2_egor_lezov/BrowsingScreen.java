package com.example.lab2_egor_lezov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BrowsingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browsing_screen);
    }
    public void goAddNewItemScreen(View view) {
        startActivity(new Intent(BrowsingScreen.this, AddNewItemScreen.class));
    }

    public void goFocusScreen(View view) {
        startActivity(new Intent(BrowsingScreen.this, FocusScreen.class));
    }
}