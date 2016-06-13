package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.Adapter.ProductDataAdapter;
import com.example.annie.glam.Models.Product;
import com.example.annie.glam.Models.ProductsResponse;
import com.example.annie.glam.R;
import com.example.annie.glam.Service.WooCommerceService;
import com.example.annie.glam.ServiceGenerator;
import com.example.annie.glam.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentFavorite extends Fragment {
    //ImageView imageViewProduct;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<Product>productsOnSale;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorite,container,false);
      //  imageViewProduct=(ImageView)v.findViewById(R.id.iv_banner);
      //  Glide.with(getActivity()).load(R.drawable.sale).into(imageViewProduct);


        recyclerView=(RecyclerView)v.findViewById(R.id.recycler_view_on_sale);

        WooCommerceService wooCommerceService= ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductsResponse>ListCategoryResponseCall=wooCommerceService.getListProduct();

        ListCategoryResponseCall.enqueue(new Callback<ProductsResponse>() {
         @Override
         public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
             ProductsResponse productResponse=response.body();
             Log.d("Product List Size",String.valueOf(productResponse.getProducts().size()));
             List<Product> productList=productResponse.getProducts();


             productsOnSale=getProductsOnSale(productList);
             Log.d("Product On Sale",String.valueOf(productsOnSale.size()));
             adapter = new ProductDataAdapter(getActivity(),productsOnSale);
             recyclerView.setAdapter(adapter);
             recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
             SpacesItemDecoration decoration = new SpacesItemDecoration(16);
             recyclerView.addItemDecoration(decoration);

         }

         @Override
         public void onFailure(Call<ProductsResponse> call, Throwable t) {

         }
     });


        return v;
    }

    private List<Product> getProductsOnSale (List<Product>productList)
    {
        List<Product>temp=new ArrayList<>();
        for (int i =0;i<productList.size();i++)
            if(productList.get(i).getOnSale()) temp.add(productList.get(i));
        return temp;
    }


}
