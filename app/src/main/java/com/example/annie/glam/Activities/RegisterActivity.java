package com.example.annie.glam.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.annie.glam.Models.User;
import com.example.annie.glam.R;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Firebase root;
    EditText edtUserName,edtPassword,edtMail;
    Button btnCreate;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtMail = (EditText) findViewById(R.id.edt_email);
        btnCreate = (Button) findViewById(R.id.btn_create);

        Firebase.setAndroidContext(this);
        root = new Firebase("https://glam-user.firebaseio.com/");



        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setName(edtUserName.getText().toString());
                user.setEmail(edtMail.getText().toString());
                user.setPassword(edtPassword.getText().toString());

                root.createUser(user.getEmail(), user.getPassword(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        user.setId(result.get("uid").toString());
                        user.saveUser();
                        root.unauth();
                        Toast.makeText(getApplicationContext(), "Your Account has been Created", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Please Login With your Email and Password", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                        Toast.makeText(getApplicationContext(),firebaseError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
