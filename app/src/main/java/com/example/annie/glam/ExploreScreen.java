package com.example.annie.glam;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.annie.glam.Adapter.ViewPagerAdapter;

public class ExploreScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);

        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager(),ExploreScreen.this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        final TabLayout.Tab Men=tabLayout.newTab();
        final TabLayout.Tab Women=tabLayout.newTab();
        final TabLayout.Tab Kids=tabLayout.newTab();
        final TabLayout.Tab Traditional=tabLayout.newTab();
        final TabLayout.Tab Special = tabLayout.newTab();

        Men.setText("MEN");
        Women.setText("WOMEN");
        Kids.setText("KIDS");
        Traditional.setText("TRADITIONAL");
        Special.setText("SPECIAL");

        tabLayout.addTab(Men,0);
        tabLayout.addTab(Women,1);
        tabLayout.addTab(Kids,2);
        tabLayout.addTab(Traditional,3);
        tabLayout.addTab(Special,4);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the actionbar_explore_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_explore_menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_explore) {

        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_setting) {

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
