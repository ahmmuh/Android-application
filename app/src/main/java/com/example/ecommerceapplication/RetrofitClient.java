package com.example.ecommerceapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://localhost:8080/api/v1/all/";
    private static RetrofitClient retrofitInstanse;
    private Retrofit retrofit;

  private RetrofitClient(){
       retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
       .build();
  }


  public static synchronized RetrofitClient getInstance(){
      if (retrofitInstanse == null) retrofitInstanse = new RetrofitClient();
      return retrofitInstanse;
  }

  public API getAPI(){
      return retrofit.create(API.class);
  }
}
