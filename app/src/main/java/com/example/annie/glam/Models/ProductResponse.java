package com.example.annie.glam.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nam Nguyen on 03/06/2016.
 */
public class ProductResponse {

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @SerializedName("product")
    @Expose
    private Product product = new Product();
}
