package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.Adapter.TabsPagerAdapter;
import com.example.annie.glam.R;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentExplore extends Fragment  {


    TabsPagerAdapter tabsPagerAdapter;
    ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_explore,container,false);

        tabsPagerAdapter = new TabsPagerAdapter(getFragmentManager());
        viewPager = (ViewPager) v.findViewById(R.id.pager_tab_strip);
        viewPager.setAdapter(tabsPagerAdapter);
        return v;
    }

}
