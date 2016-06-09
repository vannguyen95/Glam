package com.example.annie.glam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.annie.glam.R;

public class LogInActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    ImageView imageViewlogoIcon;
    Button buttonLogin;
    Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        onMap();
        Glide.with(this).load(R.drawable.glamlogo).into(imageViewlogoIcon);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onMap() {
        relativeLayout = (RelativeLayout) findViewById(R.id.layout_login);
        imageViewlogoIcon = (ImageView) findViewById(R.id.image_view_login_glam_logo);
        buttonLogin = (Button) findViewById(R.id.button_sign_in);
        buttonCreateAccount = (Button) findViewById(R.id.button_create_account);


    }
}
