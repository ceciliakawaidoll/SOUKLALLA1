package com.example.souklalla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.souklalla.structure.Product_elem;

import java.util.List;

public class categoryAdd_Adapter extends RecyclerView.Adapter<categoryAdd_Adapter.categoryAdd_holder> {


    List<Product_elem> categoryadd;

    public categoryAdd_Adapter(List<Product_elem> categoryadd) {
        this.categoryadd = categoryadd;
    }

    @NonNull
    @Override
    public categoryAdd_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_add_style,parent,false);

        return new categoryAdd_Adapter.categoryAdd_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdd_holder holder, int position) {


        holder.itemView.setTag(position);
        holder.product_name.setText(categoryadd.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryadd.size();
    }

    public class categoryAdd_holder extends RecyclerView.ViewHolder{
        TextView product_name ;
        public categoryAdd_holder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.tv_product_name);
        }
    }
}
