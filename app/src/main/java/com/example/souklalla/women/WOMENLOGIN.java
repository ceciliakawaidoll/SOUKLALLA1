package com.example.souklalla.women;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.souklalla.Connextions.Login_connection;
import com.example.souklalla.R;

public class WOMENLOGIN extends AppCompatActivity {
    public static String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_login);
        TextView text = findViewById(R.id.tv_acont);
        TextView textpass = findViewById(R.id.tv_pass);
        Button btn = findViewById(R.id.btn_login_W);

        CardView BACK = findViewById(R.id.cd_back);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENLOGIN.this, WOMENHELLO.class);
            startActivity(intent);
        });
       text.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENLOGIN.this, WOMENCREATACOUNT.class);
            startActivity(intent);
        });

        textpass.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENLOGIN.this, WOMENFORGOTPASS.class);
            startActivity(intent);
        });

        btn.setOnClickListener(v -> {
            EditText name = findViewById(R.id.name_W);
            EditText pass = findViewById(R.id.password1);
            String ip =getResources().getString(R.string.ip);
            Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            Login_connection loginConnection = new Login_connection(name.getText().toString(),pass.getText().toString(),ip);
            loginConnection.set_result(new Login_connection.Result() {
                @Override
                public void getResult(String email) {
                    if(!email.equals("")){
                        Email = email;
                        Intent intent = new Intent(WOMENLOGIN.this, WOMENHOMEPAGE.class);
                        startActivity(intent);
                    }
                }
            });
            loginConnection.execute();
        });

    }
}