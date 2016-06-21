package com.example.annie.glam.Service;

import com.example.annie.glam.Models.CategoryResponse;
import com.example.annie.glam.Models.ProductResponse;
import com.example.annie.glam.Models.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Nam Nguyen on 11/06/2016.
 */
public interface WooCommerceService {

    @GET("products/{id}")
    Call<ProductResponse> getProductById(@Path("id") int id);

    @GET("products")
    Call<ProductsResponse> getListProduct();

    @GET("products")
    Call<ProductsResponse> getListProductByCatName(@Query("filter[category]") String catName);

    @GET("products/categories")
    Call<CategoryResponse> getListCategory();
}
