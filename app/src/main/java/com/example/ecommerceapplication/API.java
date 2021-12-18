package com.example.ecommerceapplication;

import com.example.ecommerceapplication.models.Product;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

    @GET("/products")
    Call<List<Product>> getAllProducts();

    @POST("product/add")
    Call<ResponseBody> addProduct(@Body Product product);

    @POST("product/update/{id}")
    Call<ResponseBody> updateProduct(@Path("id")long productId,
                                     @Body Product product);

}
