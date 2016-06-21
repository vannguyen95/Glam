package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.Adapter.ViewPagerCartAdapter;
import com.example.annie.glam.Models.Product;
import com.example.annie.glam.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentCart extends Fragment {
    List<Product>productList= new ArrayList<>();
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart,container,false);
        viewPager=(ViewPager)v.findViewById(R.id.view_pager_cart);
        return v;
    }

    @Subscribe
    public void onMessageEvent(Product productReceived){
        productList.add(productReceived);
        viewPager.setAdapter(new ViewPagerCartAdapter(getActivity(),productList));

    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(getActivity());
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(getActivity());
        super.onStop();
    }
}
