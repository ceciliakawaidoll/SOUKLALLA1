package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.Login_connection;
import com.example.souklalla.R;
import com.example.souklalla.women.WOMENHOMEPAGE;
import com.example.souklalla.women.WOMENLOGIN;

public class UserLogin extends AppCompatActivity {
    public static String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_login);
        Button login= findViewById(R.id.user_login);
        TextView signup = findViewById(R.id.user_acont);
        CardView BACK = findViewById(R.id.cd_back);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(UserLogin.this, USERCATEGORY.class);
            startActivity(intent);
        });

       signup.setOnClickListener(v -> {
            Intent intent = new Intent(UserLogin.this, UserCreatacount.class);
            startActivity(intent);
        });

        login.setOnClickListener(v -> {

            EditText name = findViewById(R.id.user_name);
            EditText pass = findViewById(R.id.user_password);
            String ip =getResources().getString(R.string.ip);
            // Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            Login_connection loginConnection = new Login_connection(name.getText().toString(),pass.getText().toString(),ip);
            loginConnection.set_result(new Login_connection.Result() {
                @Override
                public void getResult(String email) {
                    if(!email.equals("")){
                        Email = email;
                        Intent intent = new Intent(UserLogin.this, USERCATEGORY.class);
                        startActivity(intent);
                    }
                }
            });
            loginConnection.execute();
        });


    }
}