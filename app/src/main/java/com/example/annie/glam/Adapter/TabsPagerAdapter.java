package com.example.annie.glam.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.annie.glam.Fragments.PageFragment;

/**
 * Created by Nam Nguyen on 08/06/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.

        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public String getPageTitle(int position) {
//        return "TAB " + (position + 1);
        switch (position){
            case 0:return "Men";
            case 1:return "Women";
            case 2:return "Kid";
            case 3:return "Traditional";
            case 4:return "Special";
        }
        return null;
    }
}
