package com.example.annie.glam.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.R;

/**
 * Created by Nam Nguyen on 08/06/2016.
 */
public class PageFragment extends Fragment {
    RecyclerView categoryListView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    static Context context;
    private static final String ARG_PAGE_NUMBER = "page_number";

    public PageFragment() {
    }

   public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }
/*
    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        context=activityContext;
        return fragment;
    }
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page,container,false);

        categoryListView=(RecyclerView)v.findViewById(R.id.recycler_view_explore_fragment);

        layoutManager =  new LinearLayoutManager(context);

       /* WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductResponse> ListCategoryResponseCall= service.getListProducts();
        ListCategoryResponseCall.enqueue(new Callback<ProductResponse>() {

            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                ProductResponse productResponse=response.body();
                Log.d("Product List Size",String.valueOf(productResponse.getProducts().size()));
                List<Product> productList=productResponse.getProducts();
                categoryListView.setLayoutManager(layoutManager);
                adapter = new ProductDataAdapter(context,productList);
                categoryListView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });
*/

        return v;
    }
}
