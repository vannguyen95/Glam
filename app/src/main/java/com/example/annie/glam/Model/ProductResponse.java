package com.example.annie.glam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 6/8/2016.
 */
public class ProductResponse {
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<Product>();

    /**
     *
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @param products
     *     The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
