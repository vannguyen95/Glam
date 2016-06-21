package com.example.annie.glam.Models;

import com.firebase.client.Firebase;

/**
 * Created by Nam Nguyen on 13/06/2016.
 */
public class User {

    private String id,name,email,password;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void saveUser() {
        Firebase myFirebaseRef = new Firebase("https://glam-user.firebaseio.com/");
        myFirebaseRef = myFirebaseRef.child("users").child(getId());
        myFirebaseRef.setValue(this);
    }
}
