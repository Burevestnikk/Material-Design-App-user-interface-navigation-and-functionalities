package com.example.lab2_egor_lezov;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewItemScreen extends AppCompatActivity {
    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        if (!isConnected()) {
            startActivity(new Intent(AddNewItemScreen.this, ErrorMessagesInternet.class));
        }
    }
    public void goBrowsingScreen(View view){
        if (!isConnected()) {
            startActivity(new Intent(AddNewItemScreen.this, ErrorMessagesInternet.class));
        }else{
            Toast.makeText(getApplicationContext(), "Item added successfully!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(AddNewItemScreen.this, BrowsingScreen.class));
        }
    }
}