package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.Adapter.CategoryListAdapter;
import com.example.annie.glam.Models.CategoryResponse;
import com.example.annie.glam.R;
import com.example.annie.glam.Service.WooCommerceService;
import com.example.annie.glam.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentSetting extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyler_view_category_list);

        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        //GetData
        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<CategoryResponse> categoryResponseCall = service.getListCategory();
        categoryResponseCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, retrofit2.Response<CategoryResponse> response) {
                CategoryResponse categoryResponse = response.body();

                recyclerViewAdapter = new CategoryListAdapter(getActivity(), categoryResponse.getProductCategories());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
            }
        });
        return v;
    }
}
