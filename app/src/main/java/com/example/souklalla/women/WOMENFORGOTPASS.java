package com.example.souklalla.women;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.souklalla.Connextions.verifer_connextion;
import com.example.souklalla.R;

public class WOMENFORGOTPASS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_forgotpass);
        Button bt = findViewById(R.id.bt_women_email);
        CardView BACK = findViewById(R.id.cd_back);

        bt.setOnClickListener(v -> {
            EditText email = findViewById(R.id.women_email);
            String ip =getResources().getString(R.string.ip);
            // Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            verifer_connextion VeriConnection= new verifer_connextion(email.getText().toString(),ip);
            VeriConnection.set_result(new verifer_connextion.Result() {
                @Override
                public void getResult(String email) {
                    if (!email.equals("")) {
                        WOMENLOGIN.Email = email;
                        Intent intent = new Intent(WOMENFORGOTPASS.this, WOMENVERIFICATION.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(WOMENFORGOTPASS.this, WOMENFORGOTFALSE.class);
                        startActivity(intent);
                    }
                }
            });
            VeriConnection.execute();
        });
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENFORGOTPASS.this, WOMENLOGIN.class);
            startActivity(intent);
        });


    }
}