package com.example.ecommerceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

    Product product = products.get(position);
    String url = product.getProductImage();
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.product_image);

                holder.product_id.setText("Id: " + product.getId());
                holder.product_name.setText("Product name: " + product.getName());
                holder.product_price.setText("Price");

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView product_image;
        TextView product_id,product_name, product_price,product_description;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);
            product_id = (TextView) itemView.findViewById(R.id.product_id);
            product_name = (TextView) itemView.findViewById(R.id.product_Name);
            product_price = (TextView)  itemView.findViewById(R.id.product_Price);
            product_description = (TextView) itemView.findViewById(R.id.product_description);
        }
    }
}
