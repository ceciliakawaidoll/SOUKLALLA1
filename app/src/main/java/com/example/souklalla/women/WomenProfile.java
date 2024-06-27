package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class WomenProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_profile);
        CardView BACK = findViewById(R.id.cd_back);

        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WomenProfile.this, WomenProfilehome.class);
            startActivity(intent);
        });

    }
}