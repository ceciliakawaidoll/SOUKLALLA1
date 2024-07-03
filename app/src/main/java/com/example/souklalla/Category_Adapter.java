package com.example.souklalla;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.souklalla.User.PRODUCTBUY;

import java.util.List;

import test.Product_elem;

public class Category_Adapter  extends RecyclerView.Adapter<Category_Adapter.Category_holder>{

     List<Product_elem> category;
    Context context;

    public Category_Adapter(List<Product_elem> category, Context context) {
        this.category = category;
        this.context = context;
    }


    @NonNull
    @Override
    public Category_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_show_custom,parent,false);

        return new Category_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Category_holder holder, int position) {
        holder.itemView.setTag(position);
        holder.product_name.setText(category.get(position).getName());
        holder.worke_n.setText(category.get(position).getWorker());
        holder.prod_price.setText(category.get(position).getPrice());
        holder.prod_desc.setText(category.get(position).getDescr());


        holder.card.setOnClickListener(v -> {
            Intent intent=new Intent(context, PRODUCTBUY.class);
            context.startActivity(intent);
            intent.putExtra("product_name", holder.product_name.getText().toString());
            intent.putExtra("prod_price",holder.prod_price.getText().toString());
            intent.putExtra("prod_desc",holder.prod_desc.getText().toString());
        });

        }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class Category_holder extends RecyclerView.ViewHolder{
        TextView product_name ,worke_n,prod_price,prod_desc;
        CardView card ;

        public Category_holder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.tv_product_name);
            worke_n= itemView.findViewById(R.id.tv_women_name);
             prod_price=itemView.findViewById(R.id.tv_price);
            card = itemView.findViewById(R.id.cd_show);
        }
    }
}
