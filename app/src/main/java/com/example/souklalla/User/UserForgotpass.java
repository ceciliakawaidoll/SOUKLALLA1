package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.Login_connection;
import com.example.souklalla.Connextions.Signup_connextion;
import com.example.souklalla.Connextions.verifer_connextion;
import com.example.souklalla.R;

public class UserForgotpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_forgotpass);
        Button yes = findViewById(R.id.bt_user_email);
        CardView BACK = findViewById(R.id.cd_back);

        yes.setOnClickListener(v -> {
            EditText email = findViewById(R.id.user_email);
            String ip =getResources().getString(R.string.ip);
            // Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            verifer_connextion VeriConnection= new verifer_connextion(email.getText().toString(),ip);
            VeriConnection.set_result(new verifer_connextion.Result() {
                @Override
                public void getResult(String email) {
                    if (!email.equals("")) {
                        UserLogin.Email = email;
                        Intent intent = new Intent(UserForgotpass.this, UserVerification.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(UserForgotpass.this, UserForgotpassfalse.class);
                        startActivity(intent);
                    }
                }
            });
            VeriConnection.execute();
        });

        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(UserForgotpass.this, UserLogin.class);
            startActivity(intent);
        });
    }
    }