package com.example.annie.glam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.annie.glam.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    ImageView imageViewSplashLogo;
    Firebase root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Firebase.setAndroidContext(this);
        root = new Firebase("https://glam-user.firebaseio.com/");
        checkUserLogin();

        onMapped();

        Glide.with(this).load(R.drawable.glamlogo).into(imageViewSplashLogo);


    }

    private void onMapped() {
        imageViewSplashLogo = (ImageView) findViewById(R.id.image_view_splash_glam_logo);

    }
    private void checkUserLogin() {
        //getAuth Returns the current authentication state of the Firebase client. If the client is unauthenticated, this method will return null.
        // Otherwise, the return value will be an object containing at least the fields such as uid,provider,token,expires,auth
        // https://www.firebase.com/docs/web/api/firebase/getauth.html,
        if (root.getAuth() != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, ExploreActivity.class);
                    String uid = root.getAuth().getUid();
                    intent.putExtra("user_id", uid);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);

        } else  {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, ExploreActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
}
