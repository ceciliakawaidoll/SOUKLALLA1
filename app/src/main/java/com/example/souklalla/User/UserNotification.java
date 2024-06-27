package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class UserNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_notification);
        CardView back= findViewById(R.id.cd_back);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(UserNotification.this, USERCATEGORY.class);
            startActivity(intent);
        });
    }
}