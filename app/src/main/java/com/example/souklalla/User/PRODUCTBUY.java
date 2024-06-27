package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.souklalla.R;

public class PRODUCTBUY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_buy);
        Button buy = findViewById(R.id.button2);
        ImageView plus= findViewById(R.id.iv_plus);
        ImageView minus= findViewById(R.id.iv_minus);
        TextView price= findViewById(R.id.tv_price);
        buy.setOnClickListener(v -> {
            Intent intent = new Intent(PRODUCTBUY.this, Payment.class);
            startActivity(intent);
        });
        plus.setOnClickListener(v -> {

        });


    }
}