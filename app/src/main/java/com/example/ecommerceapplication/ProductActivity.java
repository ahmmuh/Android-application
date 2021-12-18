package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerceapplication.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        API api = RetrofitClient.getInstance().getAPI();
        Call<List<Product>> call = api.getAllProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ProductActivity.this, response.code() + "", Toast.LENGTH_LONG).show();
                    return;
                }
                List<Product> products = response.body();
                recyclerView = findViewById(R.id.list);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProductActivity.this));
                recyclerView.setAdapter(new ProductAdapter(ProductActivity.this, products));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductActivity.this,t.getMessage() + "",Toast.LENGTH_LONG).show();

            }
        });
    }
}