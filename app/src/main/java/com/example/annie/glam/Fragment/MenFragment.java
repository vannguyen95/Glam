package com.example.annie.glam.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.Adapter.RecyclerViewAdapter;
import com.example.annie.glam.Model.Product;
import com.example.annie.glam.Model.ProductResponse;
import com.example.annie.glam.R;
import com.example.annie.glam.Service.Service;
import com.example.annie.glam.Service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenFragment extends Fragment {

    RecyclerView recyclerView ;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Product>productList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_men, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_tab_fragment);
        layoutManager= new LinearLayoutManager(getActivity());


        Service service = ServiceGenerator.createService(Service.class);
        Call<ProductResponse>ListProductResponseCall=service.getListProduct();
        ListProductResponseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                ProductResponse productResponse=response.body();
                Log.d("Debug",String.valueOf(productResponse.getProducts().size()));
                productList=productResponse.getProducts();
                RecyclerViewAdapter adapter= new RecyclerViewAdapter(getActivity(),productList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });

        return  view;


    }


}
