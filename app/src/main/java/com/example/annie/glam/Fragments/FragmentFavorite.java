package com.example.annie.glam.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annie.glam.R;

/**
 * Created by Nam Nguyen on 07/06/2016.
 */
public class FragmentFavorite extends Fragment {

    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorite,container,false);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar_favorite);
        toolbar.setTitle("Favorite");
        return v;
    }
}
