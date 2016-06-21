package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.annie.glam.Adapter.SpinnerAdapter;
import com.example.annie.glam.Adapter.TabsPagerAdapter;
import com.example.annie.glam.R;

import java.util.ArrayList;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentExplore extends Fragment {


    TabsPagerAdapter tabsPagerAdapter;
    ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explore, container, false);

        tabsPagerAdapter = new TabsPagerAdapter(getFragmentManager());
        viewPager = (ViewPager) v.findViewById(R.id.pager_tab_strip);
        viewPager.setAdapter(tabsPagerAdapter);

        return v;
    }

}