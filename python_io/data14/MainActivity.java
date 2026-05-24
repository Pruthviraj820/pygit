package com.example.poe14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends  AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(v->{

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Exit App");
            builder.setMessage("Do you want to exit app YES or NO");

            builder.setPositiveButton("YES" , (dialog, which) -> {
                Toast.makeText(MainActivity.this , "Exiting..." , Toast.LENGTH_SHORT).show();
                finish();
            });

            builder.setNegativeButton("NO" , (dialog, which) -> {
                Toast.makeText(MainActivity.this , "cancelled" , Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            builder.setNeutralButton("Help" , (dialog, which) -> {
                Toast.makeText(MainActivity.this , "Click yes if exit" , Toast.LENGTH_SHORT).show();

            });

            builder.show();


        });
    }
}