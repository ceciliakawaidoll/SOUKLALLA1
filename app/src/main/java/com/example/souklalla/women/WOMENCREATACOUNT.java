package com.example.souklalla.women;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.souklalla.Connextions.Signup_connextion;
import com.example.souklalla.R;

import java.net.URL;

public class WOMENCREATACOUNT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_creatacount);

        Spinner spin = findViewById(R.id.spinner);
        Button bt=findViewById(R.id.signup_btn);
        TextView tv=findViewById(R.id.textView20);
        CardView BACK = findViewById(R.id.cd_back);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENCREATACOUNT.this, WOMENLOGIN.class);
            startActivity(intent);
        });


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          String item = parent.getItemAtPosition(position).toString();

          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
          });

        getResources().getStringArray(R.array.wilays);





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wilays)){



            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spin.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);




        TextView name = findViewById(R.id.name_W);
        TextView lastname = findViewById(R.id.lastname);
        TextView email = findViewById(R.id.email);
        TextView phone= findViewById(R.id.phone);
        TextView pass1 = findViewById(R.id.password1);




        bt.setOnClickListener(v -> {
            URL url = null;
            String fullname = name.getText().toString()+" "+ lastname.getText().toString();
            String Email = email.getText().toString();
            String Phone = phone.getText().toString();
            String Pass1 = pass1.getText().toString();
            String Wilaya = spin.getSelectedItem().toString();
            //String res = String.valueOf(new Sign_up_check(Email,Phone).execute());
            String ip = getResources().getString(R.string.ip);
            String res = String.valueOf(new Signup_connextion(fullname,Email,Phone,Pass1,Wilaya,ip,"Worker").execute());
            Intent intent = new Intent(WOMENCREATACOUNT.this, WOMENHOMEPAGE.class);



            startActivity(intent);
        });


        tv.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENCREATACOUNT.this, TERMSWOMEN.class);
            startActivity(intent);
        });





    }
}