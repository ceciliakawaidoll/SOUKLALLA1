package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.payment);
        Button bt = findViewById(R.id.signup_btn);
        CardView BACK = findViewById(R.id.cd_back);

        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(Payment.this, PRODUCTBUY.class);
            startActivity(intent);
        });

        bt.setOnClickListener(v -> {
            Intent intent = new Intent(Payment.this, PaymentVerifi.class);
            startActivity(intent);
        });
    }
}