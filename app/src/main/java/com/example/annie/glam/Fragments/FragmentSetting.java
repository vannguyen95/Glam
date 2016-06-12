package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

    Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting,container,false);

        toolbar = (Toolbar) v.findViewById(R.id.toolbar_setting);
        toolbar.setTitle("Setting");

//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        and if you want to add items to the toolbar within MyFragment you must add this line inside onCreateView function
//        we identify them in menu/fragment_menu.xml
//        after that override,onCreateOptionsMenu,onOptionsItemSelected
//        setHasOptionsMenu(false);

        return v;
    }


}
