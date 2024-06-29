package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.verifer_connextion;
import com.example.souklalla.R;

public class UserForgotpassfalse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_forgotpassfalse);
        CardView BACK = findViewById(R.id.cd_back);
        Button go =findViewById(R.id.btn_login_forgot);

        go.setOnClickListener(v -> {
            EditText email = findViewById(R.id.U_email);
            String ip =getResources().getString(R.string.ip);
            // Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            verifer_connextion VeriConnection= new verifer_connextion(email.getText().toString(),ip);
            VeriConnection.set_result(new verifer_connextion.Result() {
                @Override
                public void getResult(String email) {
                    if (!email.equals("")) {
                        UserLogin.Email = email;
                        Intent intent = new Intent(UserForgotpassfalse.this, UserVerification.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(UserForgotpassfalse.this, UserForgotpassfalse.class);
                        startActivity(intent);
                    }
                }
            });
            VeriConnection.execute();
        });

        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(UserForgotpassfalse.this, UserLogin.class);
            startActivity(intent);
        });
    }
}