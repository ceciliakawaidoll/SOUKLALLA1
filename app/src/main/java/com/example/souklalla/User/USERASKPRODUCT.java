package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class USERASKPRODUCT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_askpoduct);

        Button ask= findViewById(R.id.bt_asking);
        CardView BACK = findViewById(R.id.cd_back);

        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(USERASKPRODUCT.this, USERCATEGORY.class);
            startActivity(intent);
        });

        ask.setOnClickListener(v -> {
            Intent intent = new Intent(USERASKPRODUCT.this, USERCATEGORY.class);
            startActivity(intent);
        });


    }

}