package com.example.lab2_egor_lezov;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CharacteristicScreen extends AppCompatActivity {
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
        VideoView videoView = findViewById(R.id.videoView);
        String videoUrl = "https://abhiandroid.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4";
        videoView.setVideoURI(Uri.parse(videoUrl));
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

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