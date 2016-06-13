package com.example.annie.glam.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.annie.glam.Fragments.PageFragment;

import java.util.ArrayList;

/**
 * Created by Nam Nguyen on 08/06/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

   /* List<ProductCategory> childCategoryTitle;
    Context context;
    public TabsPagerAdapter(FragmentManager fm,List<ProductCategory>childCategoryTitle,Context context) {

        super(fm);
        this.childCategoryTitle=childCategoryTitle;
        this.context=context;
    }*/

    ArrayList<String> childCategoryTitle;
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
        return 3;
    }
/*
    @Override
    public CharSequence getPageTitle(int position) {
        return childCategoryTitle.get(position).getName();
    }
*/

    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB " + (position + 1);
    }
}
