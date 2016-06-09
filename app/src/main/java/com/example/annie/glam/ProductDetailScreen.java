package com.example.annie.glam;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.annie.glam.Adapter.ImageSliderAdapter;
import com.example.annie.glam.ViewPager.CirclePageIndicator;
import com.example.annie.glam.ViewPager.PageIndicator;

public class ProductDetailScreen extends AppCompatActivity {
    int [] imageList= new int[]{R.drawable.slider3,R.drawable.slider2,R.drawable.slider};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_product_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager_product_detail);
        PageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator_product_detail);
        mIndicator.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setAdapter(new ImageSliderAdapter(this,imageList));
        mIndicator.setViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the actionbar_explore_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_product_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_buy) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
