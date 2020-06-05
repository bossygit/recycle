package com.nasande.recycling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nasande.recycling.model.Product;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ProductHolder> {

    private List<Product> products;
    private Context context;

    public itemAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        //Get the data

        holder.productTitle.setText(products.get(position).getTitle());
        holder.productPrice.setText(products.get(position).getPrice__number());
        Glide.with(context)
                .load(products.get(position).getField_image())
                .into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder{


        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.icon);
            productTitle = itemView.findViewById(R.id.firstLine);
            productPrice = itemView.findViewById(R.id.secondLine);
        }
    }
}
