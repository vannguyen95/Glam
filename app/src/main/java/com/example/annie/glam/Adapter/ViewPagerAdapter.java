package com.example.annie.glam.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.example.annie.glam.Fragment.MenFragment;
import com.example.annie.glam.R;

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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        // removes the existing fragment calling onDestroy
        ft.replace(R.id.flContainer, fragmentA);
        ft.commit();
        return super.instantiateItem(container, position);
    }
}
