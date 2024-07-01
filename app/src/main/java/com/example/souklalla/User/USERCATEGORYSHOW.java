package com.example.souklalla.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.souklalla.Category;
import com.example.souklalla.Category_Adapter;
import com.example.souklalla.Connextions.get_products;
import com.example.souklalla.R;
import com.example.souklalla.categoryAdd_Adapter;

import java.util.ArrayList;
import java.util.List;

import test.Product_elem;

public class USERCATEGORYSHOW extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_categoryshow);
        CardView BACK = findViewById(R.id.cd_back);
        RecyclerView category_list = findViewById(R.id.rv_product);


        List<Product_elem> category = new ArrayList<>();
        //for (int i=0;i<10;i++){
        //    category.add(new Category("إسم المنتوج  "+ i) );
       // }

        Intent intent = getIntent();
        String cat = intent.getStringExtra("cat");

        String ip = getResources().getString(R.string.ip);
        get_products prods = new get_products("getprodU",ip,cat);
        Category_Adapter adapter = new Category_Adapter(category,this);
      category_list.setAdapter(adapter);
        category_list.setLayoutManager(new LinearLayoutManager(this));
        prods.set_result(new get_products.Result_prod() {

            @Override
            public void getproducts(List<Product_elem> products) {
                category.addAll(products);
                adapter.notifyDataSetChanged();
            }
        });
        prods.execute();

        BACK.setOnClickListener(v -> {
            Intent intent1 = new Intent(USERCATEGORYSHOW.this, USERCATEGORY.class);
            startActivity(intent1);
        });

    }
}