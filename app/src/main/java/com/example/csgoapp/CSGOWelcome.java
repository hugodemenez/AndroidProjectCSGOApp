package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CSGOWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomelayout);

        // Initialize Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // If not logged in, finish current activity, and go to login screen
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            finish();
        }


    }

    public void onClickLogout(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}