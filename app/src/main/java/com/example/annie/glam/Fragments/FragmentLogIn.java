package com.example.annie.glam.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annie.glam.Activities.RegisterActivity;
import com.example.annie.glam.Activities.ExploreActivity;
import com.example.annie.glam.Adapter.ImageSliderAdapter;
import com.example.annie.glam.R;
import com.example.annie.glam.ViewPager.CirclePageIndicator;
import com.example.annie.glam.ViewPager.PageIndicator;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by Nam Nguyen on 11/06/2016.
 */
public class FragmentLogIn extends Fragment implements View.OnClickListener {

    private static final long ANIM_VIEWPAGER_DELAY = 5000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 10000;
    int[] imageList = new int[]{R.drawable.slider3, R.drawable.slider2, R.drawable.slider};
    private ViewPager mViewPager;
    private PageIndicator mIndicator;
    EditText edEmail,edPass;
    Button sigInButton;
    TextView tvForgetPass,tvNewHere;
    Firebase root;
    private Handler handler;
    boolean stopSliding = false;
    private Runnable animateViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login,container,false);
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mIndicator = (CirclePageIndicator) v.findViewById(R.id.indicator);

        edEmail = (EditText) v.findViewById(R.id.edit_text_email);
        edPass = (EditText) v.findViewById(R.id.edit_text_password);
        sigInButton = (Button) v.findViewById(R.id.button_sign_in_2);
        tvForgetPass = (TextView) v.findViewById(R.id.tv_forget_pass);
        tvNewHere = (TextView) v.findViewById(R.id.tv_new_here);

        Firebase.setAndroidContext(getActivity());
        root = new Firebase("https://glam-user.firebaseio.com/");

        mIndicator.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        break;

                    case MotionEvent.ACTION_UP:
                        // calls when touch release on ViewPager
                    {
                        stopSliding = false;
                        handler.postDelayed(animateViewPager,
                                ANIM_VIEWPAGER_DELAY_USER_VIEW);
                        break;
                    }


                    case MotionEvent.ACTION_MOVE:
                        // calls when ViewPager touch
                        if (handler != null && stopSliding == false) {
                            stopSliding = true;
                            runnable(10);
                            handler.removeCallbacks(animateViewPager);
                        }
                        break;
                }
                return false;

            }
        });
        sigInButton.setOnClickListener(this);
        tvForgetPass.setOnClickListener(this);
        tvNewHere.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_sign_in_2:
                root.authWithPassword(edEmail.getText().toString(), edPass.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), ExploreActivity.class);
                        intent.putExtra("email",edEmail.getText().toString());
                        startActivity(intent);
                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // there was an error
                        Toast.makeText(getActivity(),firebaseError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.tv_forget_pass:
                break;
            case R.id.tv_new_here:
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
                break;
        }
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

    public void runnable(final int size) {
        handler = new Handler();
        animateViewPager = new Runnable() {
            public void run() {
                if (!stopSliding) {
                    if (mViewPager.getCurrentItem() == size - 1) {
                        mViewPager.setCurrentItem(0);
                    } else {
                        mViewPager.setCurrentItem(
                                mViewPager.getCurrentItem() + 1, true);
                    }
                    handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                }
            }
        };
    }
    @Override
    public void onResume() {

        mViewPager.setAdapter(new ImageSliderAdapter(getActivity(), imageList));

        mIndicator.setViewPager(mViewPager);
        runnable(10);
        //Re-run callback
        handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);

        super.onResume();
    }
}
