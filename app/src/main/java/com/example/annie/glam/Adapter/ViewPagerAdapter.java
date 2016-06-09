package com.example.annie.glam.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.annie.glam.Fragments.FragmentChild;
import com.example.annie.glam.Fragments.FragmentMen;
import com.example.annie.glam.Fragments.FragmentWomen;

/**
 * Created by Nam Nguyen on 08/06/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentMen fragmentMen = new FragmentMen();
                return fragmentMen;
            case 1:
                FragmentWomen fragmentWomen = new FragmentWomen();
                return  fragmentWomen;
            case 2:
                FragmentChild fragmentChild = new FragmentChild();
                return  fragmentChild;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
