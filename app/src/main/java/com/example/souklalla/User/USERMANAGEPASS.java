package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.R;

public class USERMANAGEPASS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_managepass);
        Button pass=findViewById(R.id.buton_pass);
        CardView BACK = findViewById(R.id.cd_back);
        TextView textView=findViewById(R.id.tv_forgotpassuser);


       textView.setOnClickListener(v -> {
            Intent intent = new Intent(USERMANAGEPASS.this, UserForgotpass.class);
            startActivity(intent);
        });

        textView.setOnClickListener(v -> {
            Intent intent = new Intent(USERMANAGEPASS.this, UserForgotpass.class);
            startActivity(intent);
        });
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(USERMANAGEPASS.this, USERHOMEPROFILE.class);
            startActivity(intent);
        });

        pass.setOnClickListener(v -> {
            Intent intent = new Intent(USERMANAGEPASS.this, USERHOMEPROFILE.class);
            startActivity(intent);
        });
    }
}