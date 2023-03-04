package com.example.lab2_egor_lezov;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class CharacteristicScreen extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characteristic_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        youTubePlayerView = findViewById(R.id.videoView);

        if (!isConnected()) {
            startActivity(new Intent(CharacteristicScreen.this, ErrorMessagesInternet.class));
        }
    }

    public void goPersonalizationScreen(View view){
        if (!isConnected()) {
            startActivity(new Intent(CharacteristicScreen.this, ErrorMessagesInternet.class));
        }else{
            startActivity(new Intent(CharacteristicScreen.this, PersonalizationScreen.class));
        }
    }

    @SuppressLint("MissingPermission")
    public void goBrowsingScreen(View view){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Purchase", "Purchase", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(CharacteristicScreen.this, "Purchase");
        builder.setContentTitle("Purchase");
        builder.setContentText("Thank you for being interested in our product!");
        builder.setSmallIcon(R.drawable.shopping_bag);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(CharacteristicScreen.this);
        managerCompat.notify(1, builder.build());

        Toast.makeText(getApplicationContext(), "Redirecting to the payment page...", Toast.LENGTH_LONG).show();

        startActivity(new Intent(CharacteristicScreen.this, BrowsingScreen.class));
    }
}