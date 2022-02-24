package com.example.csgoapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class CSGOLogin extends AppCompatActivity {
    private EditText emailAddress;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        emailAddress = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void onClickLogin(View view) {
        Context context =this;
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress.getText()).matches() || TextUtils.isEmpty(emailAddress.getText())){
            emailAddress.setError("Please provide a valid address");
            emailAddress.requestFocus();
            return;
        }
        else{
            if(password.length() < 6){
                password.setError("Enter a password longer than 6 characters");
                password.requestFocus();
                return;
            }
        }


        mAuth.signInWithEmailAndPassword(emailAddress.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            CSGOActivityStarter starter =new CSGOActivityStarter(context,CSGOWelcome.class);
                        } else {
                            password.setError("Wrong password");
                            password.requestFocus();
                        }
                    }
                });

        mAuth.createUserWithEmailAndPassword(emailAddress.getText().toString(),password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Map<String,String> extras = new HashMap<String,String>() {{
                                put("email",emailAddress.getText().toString());
                            }};

                            CSGOActivityStarter starter =new CSGOActivityStarter(context,extras,CSGOWelcome.class);
                        }
                    }
                }
        );
    }

    public void onClickSignin(View view) {
        Map<String,String> extras = new HashMap<String,String>() {{
            put("email",emailAddress.getText().toString());
        }};
        CSGOActivityStarter starter =new CSGOActivityStarter(this,extras,CSGOSign.class);
    }


}