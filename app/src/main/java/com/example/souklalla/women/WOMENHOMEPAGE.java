package com.example.souklalla.women;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.souklalla.Connextions.get_products;
import com.example.souklalla.R;
import com.example.souklalla.categoryAdd_Adapter;
import test.Product_elem;
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


        List<Product_elem> categoryadd = new ArrayList<>();
        //for (int i=0;i<10;i++) {
          //  categoryadd.add(new CategoryAdd("إسم المنتوج  " + i));
        //}
        String ip = getResources().getString(R.string.ip);
        get_products prods = new get_products(ip);
        categoryAdd_Adapter adapter = new categoryAdd_Adapter(categoryadd);
        category_list.setAdapter(adapter);
        category_list.setLayoutManager(new LinearLayoutManager(this));

        prods.set_result(new get_products.Result_prod() {

            @Override
            public void getproducts(List<Product_elem> products) {
                categoryadd.addAll(products);
                adapter.notifyDataSetChanged();
            }
        });
        prods.execute();



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