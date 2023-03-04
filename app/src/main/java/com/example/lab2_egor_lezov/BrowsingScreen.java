package com.example.lab2_egor_lezov;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BrowsingScreen extends AppCompatActivity {

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browsing_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        if (!isConnected()) {
            startActivity(new Intent(BrowsingScreen.this, ErrorMessagesInternet.class));
        }
    }
    public void goAddNewItemScreen(View view) {
        startActivity(new Intent(BrowsingScreen.this, AddNewItemScreen.class));
    }

    public void goFocusScreen(View view) {
        startActivity(new Intent(BrowsingScreen.this, FocusScreen.class));
    }
    public void goCharacteristicsScreen(View view) {
        startActivity(new Intent(BrowsingScreen.this, CharacteristicScreen.class));
    }

    public void goPersonalizationScreen(View view){
        startActivity(new Intent(BrowsingScreen.this, PersonalizationScreen.class));
    }
}