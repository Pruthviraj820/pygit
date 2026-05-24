package com.example.poe18;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btnNotify);

       NotificationChannel channel = new NotificationChannel(
               "my_channel",
                    "My Channel",
               NotificationManager.IMPORTANCE_DEFAULT
       );

       NotificationManager manager = getSystemService(NotificationManager.class);

       manager.createNotificationChannel(channel);

       btnNotify.setOnClickListener(v->{

           Notification notification = new Notification.Builder(this , "my_channel")
                   .setSmallIcon(android.R.drawable.ic_dialog_info)
                   .setContentTitle("Notification")
                   .setContentText("This is Notification")
                   .build();

           manager.notify(1 , notification);
       });
    }
}

//in activity.xml create only button
//In manifest : uses permission post notifications