package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.annie.glam.Adapter.CategoryListAdapter;
import com.example.annie.glam.Models.CategoryResponse;
import com.example.annie.glam.Models.ProductsResponse;
import com.example.annie.glam.R;
import com.example.annie.glam.Service.WooCommerceService;
import com.example.annie.glam.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Nam Nguyen on 08/06/2016.
 */
public class PageFragment extends Fragment {

    private static final String ARG_PAGE_NUMBER = "page_number";
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    public PageFragment() {}

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyler_view_category_list);

        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);

        int page = getArguments().getInt(ARG_PAGE_NUMBER,-1);
        switch (page){
            case 1:
                //GetData

                Call<ProductsResponse> postersResponseCall = service.getListProductByCatName("Posters");
                postersResponseCall.enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                        ProductsResponse categoryResponse = response.body();

                        recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProducts());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                    }
                });
                break;
            case 2:
                Call<ProductsResponse> albumsResponseCall = service.getListProductByCatName("Albums");
                albumsResponseCall.enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                        ProductsResponse categoryResponse = response.body();

                        recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProducts());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                    }
                });
                break;
            case 3:
                Call<ProductsResponse> singlesResponseCall = service.getListProductByCatName("Singles");
                singlesResponseCall.enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                        ProductsResponse categoryResponse = response.body();

                        recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProducts());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                    }
                });
                break;
            case 4:
                Call<ProductsResponse> hoodiesResponseCall = service.getListProductByCatName("Hoodies");
                hoodiesResponseCall.enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                        ProductsResponse categoryResponse = response.body();

                        recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProducts());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                    }
                });
                break;
            case 5:
                Call<ProductsResponse> tshirtsResponseCall = service.getListProductByCatName("T-shirts");
                tshirtsResponseCall.enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                        ProductsResponse categoryResponse = response.body();

                        recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProducts());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                    }
                });
                break;
        }
        return v;
    }
}
