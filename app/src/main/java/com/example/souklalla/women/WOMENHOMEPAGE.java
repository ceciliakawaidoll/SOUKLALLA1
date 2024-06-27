package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.souklalla.Category;
import com.example.souklalla.CategoryAdd;
import com.example.souklalla.Category_Adapter;
import com.example.souklalla.R;
import com.example.souklalla.categoryAdd_Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class WOMENHOMEPAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.women_homepage);
        FloatingActionButton ft = findViewById(R.id.flotadd);
        ImageView noti= findViewById(R.id.iv_notifi);
        ImageView profile= findViewById(R.id.iv_profile);
        RecyclerView category_list = findViewById(R.id.rv_product_home);


        List<CategoryAdd> categoryadd = new ArrayList<>();
        for (int i=0;i<10;i++) {
            categoryadd.add(new CategoryAdd("إسم المنتوج  " + i));
        }
        categoryAdd_Adapter adapter = new categoryAdd_Adapter(categoryadd);
        category_list.setAdapter(adapter);
        category_list.setLayoutManager(new LinearLayoutManager(this));

        ft.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENHOMEPAGE.this, PRODUCTADD.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENHOMEPAGE.this, WomenProfilehome.class);
            startActivity(intent);
        });

        noti.setOnClickListener(v -> {
            Intent intent = new Intent(WOMENHOMEPAGE.this, WomenNotification.class);
            startActivity(intent);
        });

    }
}