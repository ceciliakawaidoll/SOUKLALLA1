package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class WomenEditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_edit_profile);

        CardView BACK = findViewById(R.id.cd_back);

        Button button = findViewById(R.id.button7);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(WomenEditProfile.this, WomenProfilehome.class);
            startActivity(intent);
        });
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WomenEditProfile.this, WomenProfilehome.class);
            startActivity(intent);
        });
    }
}