package com.example.annie.glam.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.annie.glam.Adapter.SpinnerAdapter;
import com.example.annie.glam.Fragments.FragmentCart;
import com.example.annie.glam.Fragments.FragmentExplore;
import com.example.annie.glam.Fragments.FragmentFavorite;
import com.example.annie.glam.Fragments.FragmentLogOut;
import com.example.annie.glam.Fragments.FragmentSetting;
import com.example.annie.glam.R;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Spinner spinner;
    SpinnerAdapter spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentExplore fragmentExplore = new FragmentExplore();
        fragmentTransaction.replace(R.id.content_layout, fragmentExplore);
        fragmentTransaction.commit();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.spinner_nav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Popular");
        list.add("Latest");
        list.add("Discount");
        list.add("On Sale");
        list.add("Upcoming");

        spinnerAdapter = new SpinnerAdapter(getApplicationContext(),list);
        spinner.setAdapter(spinnerAdapter);


        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        toolbar.setNavigationOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_explore:

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentExplore fragmentExplore = new FragmentExplore();
                fragmentTransaction.replace(R.id.content_layout, fragmentExplore);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_favorite:
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                FragmentFavorite fragmentFavorite = new FragmentFavorite();
                fragmentTransaction1.replace(R.id.content_layout, fragmentFavorite);
                fragmentTransaction1.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_cart:
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                FragmentCart fragmentCart = new FragmentCart();
                fragmentTransaction2.replace(R.id.content_layout, fragmentCart);
                fragmentTransaction2.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_setting:
                FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                FragmentSetting fragmentSetting = new FragmentSetting();
                fragmentTransaction3.replace(R.id.content_layout, fragmentSetting);
                fragmentTransaction3.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_logout:
                FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                FragmentLogOut fragmentLogOut = new FragmentLogOut();
                fragmentTransaction4.replace(R.id.content_layout, fragmentLogOut);
                fragmentTransaction4.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(getApplicationContext(), "Selected  : " + item,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
