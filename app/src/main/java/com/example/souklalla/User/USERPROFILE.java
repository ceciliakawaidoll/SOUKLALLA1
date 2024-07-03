package com.example.souklalla.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.souklalla.Connextions.getprofil_conextion;
import com.example.souklalla.R;
import com.example.souklalla.women.WOMENLOGIN;

import test.Profile;

public class USERPROFILE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        TextView name= findViewById(R.id.tv_uname);
        TextView email= findViewById(R.id.tv_uemail);
        TextView phone= findViewById(R.id.tv_uphone);
        String ip = getResources().getString(R.string.ip);
        getprofil_conextion prof = new getprofil_conextion(ip, UserLogin.Email);
        prof.set_result(new getprofil_conextion.Result_prof() {

            @Override
            public void getprofile(Profile profile) {
                name.setText(profile.getFullname());
                email.setText(profile.getEmail());
                phone.setText(profile.getPhone());

            }
        });
        prof.execute();


        CardView BACK = findViewById(R.id.cd_back);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(USERPROFILE.this, USERHOMEPROFILE.class);
            startActivity(intent);
        });
    }

}