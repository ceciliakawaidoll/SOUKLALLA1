package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.About;
import com.example.souklalla.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.settings);
        ImageView faforit = findViewById(R.id.setting_favorit);
        ImageView about = findViewById(R.id.setting_about);
        ImageView profile = findViewById(R.id.setting_profile);
        CardView BACK = findViewById(R.id.CD_back);

       faforit.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Favorite.class);
            startActivity(intent);
        });


        about.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, About.class);
            startActivity(intent);
        });


       profile.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, USERHOMEPROFILE.class);
            startActivity(intent);
        });



        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, USERCATEGORY.class);
            startActivity(intent);
        });

    }
}