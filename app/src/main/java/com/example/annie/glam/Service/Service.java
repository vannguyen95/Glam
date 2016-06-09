package com.example.annie.glam.Service;

import com.example.annie.glam.Model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SONY on 6/8/2016.
 */
public interface Service {
    @GET("getAllProduct")
    Call<ProductResponse>getListProduct();
}
