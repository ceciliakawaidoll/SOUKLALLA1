package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.verifer_connextion;
import com.example.souklalla.R;
import com.example.souklalla.User.UserForgotpassfalse;
import com.example.souklalla.User.UserLogin;
import com.example.souklalla.User.UserVerification;

public class WOMENFORGOTFALSE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_forgotpassfalse);
        Button yes = findViewById(R.id.btn_login_W);
        CardView BACK = findViewById(R.id.cd_back);

       yes.setOnClickListener(v -> {
           EditText email = findViewById(R.id.name_W);
           String ip =getResources().getString(R.string.ip);
           // Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
           verifer_connextion VeriConnection= new verifer_connextion(email.getText().toString(),ip);
           VeriConnection.set_result(new verifer_connextion.Result() {
               @Override
               public void getResult(String email) {
                   if (!email.equals("")) {
                       WOMENLOGIN.Email = email;
                       Intent intent = new Intent(WOMENFORGOTFALSE.this, WOMENVERIFICATION.class);
                       startActivity(intent);
                   } else {
                       Intent intent = new Intent(WOMENFORGOTFALSE.this, WOMENFORGOTFALSE.class);
                       startActivity(intent);
                   }
               }
           });
           VeriConnection.execute();
        });
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENFORGOTFALSE.this, WOMENLOGIN.class);
            startActivity(intent);
        });

    }
}