package com.example.souklalla.women;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.Signup_connextion;
import com.example.souklalla.Connextions.product_connextion;
import com.example.souklalla.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URL;

public class PRODUCTADD extends AppCompatActivity {
     FloatingActionButton BSelectImage;
    ImageView IVPreviewImage;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_add);
       Spinner spinner = findViewById(R.id.spinner2);
        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);
        CardView BACK = findViewById(R.id.cd_back);
        Button add= findViewById(R.id.btt_add);
        BACK.setOnClickListener(v -> {
            Intent intent = new Intent(PRODUCTADD.this, WOMENHOMEPAGE.class);
            startActivity(intent);
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String item = parent.getItemAtPosition(position).toString();

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        getResources().getStringArray(R.array.category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.category)){



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
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);


        EditText product_name = findViewById(R.id.product_name_add);
        EditText product_desc = findViewById(R.id.product_descr);
        EditText product_price = findViewById(R.id.product_price);


        add.setOnClickListener(v -> {

            String pro_n = product_name .getText().toString();
            String product_des = product_desc.getText().toString();
            String price =product_price.getText().toString();
            String pro_type = spinner.getSelectedItem().toString();
            String ip = getResources().getString(R.string.ip);
            String res = String.valueOf(new product_connextion(pro_n,product_des,price,pro_type,WOMENLOGIN.Email,ip).execute());
            Intent intent = new Intent(PRODUCTADD.this, WOMENHOMEPAGE.class);
            startActivity(intent);
        });





    }









    }






