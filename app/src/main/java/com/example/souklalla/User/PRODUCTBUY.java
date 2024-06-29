package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.souklalla.Connextions.get_products;
import com.example.souklalla.R;
import com.example.souklalla.categoryAdd_Adapter;

import java.util.ArrayList;
import java.util.List;

import test.Product_elem;

public class PRODUCTBUY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_buy);
        Button buy = findViewById(R.id.btn_login_W);
        ImageView plus= findViewById(R.id.iv_plus);
        ImageView minus= findViewById(R.id.iv_minus);
        TextView price= findViewById(R.id.tv_price);
        TextView number = findViewById(R.id.tv_number);
        TextView name = findViewById(R.id.tv_namep);
        TextView desc = findViewById(R.id.tv_desc_p);
        CardView back =findViewById(R.id.cd_back);


        back.setOnClickListener(v -> {
            Intent intent = new Intent(PRODUCTBUY.this, USERCATEGORY.class);
            startActivity(intent);
        });
        buy.setOnClickListener(v -> {
            Intent intent = new Intent(PRODUCTBUY.this, Payment.class);
            startActivity(intent);
        });
        plus.setOnClickListener(v -> {
            int num = Integer.parseInt(number.getText().toString());
            number.setText(String.valueOf(num+1));
            price.setText(String.valueOf((num+1)*1500));
        });
        minus.setOnClickListener(v -> {
            int num = Integer.parseInt(number.getText().toString());
            number.setText(String.valueOf(num-1));
            price.setText(String.valueOf((num-1)*1500));
        });


    }
}