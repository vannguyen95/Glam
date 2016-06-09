package com.example.annie.glam.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.annie.glam.Adapter.ViewPagerAdapter;
import com.example.annie.glam.R;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentExplore extends Fragment implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    TabHost tabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explore,container,false);

        tabHost = (TabHost) v.findViewById(R.id.tab);
        tabHost.setup();
        viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabHost.TabSpec tabMen = tabHost.newTabSpec("Men");
        tabMen.setIndicator("Men");
        tabMen.setContent(new FakeContent(getActivity()));
        tabHost.addTab(tabMen);

        TabHost.TabSpec tabWomen = tabHost.newTabSpec("Women");
        tabWomen.setIndicator("Women");
        tabWomen.setContent(new FakeContent(getActivity()));
        tabHost.addTab(tabWomen);

        TabHost.TabSpec tabChild = tabHost.newTabSpec("Child");
        tabChild.setIndicator("Child");
        tabChild.setContent(new FakeContent(getActivity()));
        tabHost.addTab(tabChild);

        tabHost.setOnTabChangedListener(this);
        viewPager.setOnPageChangeListener(this);
        return v;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
        int vitri = tabHost.getCurrentTab();
        viewPager.setCurrentItem(vitri);
    }

    public class FakeContent implements TabHost.TabContentFactory{
        Context context;

        public FakeContent(Context context) {
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View view = new View(context);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }
}
