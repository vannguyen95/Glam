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

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relativeLayout;
    ImageView imvlogoIcon;
    Button btnLogin;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        onMap();

        Glide.with(this).load(R.drawable.glamlogo).into(imvlogoIcon);

        btnLogin.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);
    }

    private void onMap() {
        relativeLayout = (RelativeLayout) findViewById(R.id.layout_login);
        imvlogoIcon = (ImageView) findViewById(R.id.imv_login_glam_logo);
        btnLogin = (Button) findViewById(R.id.btn_sign_in);
        btnCreateAccount = (Button) findViewById(R.id.btn_create_account);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_in:
                Intent intent = new Intent(LogInActivity.this,SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_create_account:
                Intent intent1 = new Intent(LogInActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

