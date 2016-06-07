package com.example.annie.glam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {
ImageView imageViewSplashLogo;


    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        onMapped();

        Picasso.with(this).load(R.drawable.glamlogo).into(imageViewSplashLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
    
    private void onMapped()
    {
        imageViewSplashLogo=(ImageView)findViewById(R.id.image_view_splash_glam_logo);

    }
}
