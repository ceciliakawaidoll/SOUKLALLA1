package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.getprofil_conextion;
import com.example.souklalla.R;

import test.Profile;

public class WomenProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_profile);
        CardView BACK = findViewById(R.id.cd_back);
        TextView name= findViewById(R.id.tv_wname);
        TextView email= findViewById(R.id.tv_wemail);
        TextView phone= findViewById(R.id.tv_wphone);
        name.setText("fullname");
        String ip = getResources().getString(R.string.ip);
        getprofil_conextion prof = new getprofil_conextion(ip,WOMENLOGIN.Email);
        prof.set_result(new getprofil_conextion.Result_prof() {

            @Override
            public void getprofile(Profile p) {
              //name.setText(p.getFullname());

              email.setText(p.getEmail());
              phone.setText(p.getPhone());

            }


        });

        prof.execute();


        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WomenProfile.this, WomenProfilehome.class);
            startActivity(intent);
        });

    }
}