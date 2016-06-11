package com.example.annie.glam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.annie.glam.Adapter.ImageSliderAdapter;
import com.example.annie.glam.R;
import com.example.annie.glam.ViewPager.CirclePageIndicator;
import com.example.annie.glam.ViewPager.PageIndicator;

/**
 * Created by Nam Nguyen on 11/06/2016.
 */
public class SignInActivity extends AppCompatActivity {

    private static final long ANIM_VIEWPAGER_DELAY = 5000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 10000;
    PageIndicator mIndicator;
    int[] imageList = new int[]{R.drawable.slider3, R.drawable.slider2, R.drawable.slider};
    boolean stopSliding = false;
    Button sigInButton;
    private ViewPager mViewPager;
    private Runnable animateViewPager;
    private Handler handler;
    EditText edEmail,edPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        edEmail = (EditText) findViewById(R.id.edit_text_email);
        edPass = (EditText) findViewById(R.id.edit_text_password);

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
        sigInButton = (Button) findViewById(R.id.button_sign_in_2);
        sigInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
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

        mViewPager.setAdapter(new ImageSliderAdapter(this, imageList));

        mIndicator.setViewPager(mViewPager);
        runnable(10);
        //Re-run callback
        handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);

        super.onResume();
    }



}
