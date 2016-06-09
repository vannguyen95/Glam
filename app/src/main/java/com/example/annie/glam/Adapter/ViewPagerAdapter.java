package com.example.annie.glam.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.annie.glam.Fragment.MenFragment;

/**
 * Created by SONY on 6/7/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm,Context context) {
        super(fm);this.context=context;
    }
    private Context context;
    @Override
    public Fragment getItem(int position) {
       return new MenFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }


}
