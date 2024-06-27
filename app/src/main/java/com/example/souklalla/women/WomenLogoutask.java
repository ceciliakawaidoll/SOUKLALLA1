package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class WomenLogoutask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_logoutask);
        CardView BACK = findViewById(R.id.cd_back);
        Button btyes = findViewById(R.id.bt_yes);
        Button out = findViewById(R.id.bt_logout);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WomenLogoutask.this, WomenProfilehome.class);
            startActivity(intent);
        });



        btyes.setOnClickListener(v -> {
            Intent intent = new Intent(WomenLogoutask.this, WOMENHELLO.class);
            startActivity(intent);
        });


        out.setOnClickListener(v -> {
            Intent intent = new Intent(WomenLogoutask.this, WomenProfilehome.class);
            startActivity(intent);
        });
    }
}