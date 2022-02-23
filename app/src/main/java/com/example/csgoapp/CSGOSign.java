package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CSGOSign extends AppCompatActivity {

    private EditText emailAdress;
    private EditText password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signlayout);
        emailAdress = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();


        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                final String email = extras.getString("email");
                emailAdress.setText(email);
            }
        }
    }


    public void onClickBackButton(View view) {

        startActivity(getIntent(emailAdress.getText().toString(),CSGOLogin.class));
    }


    public void onClickSignin(View view){
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAdress.getText()).matches() || TextUtils.isEmpty(emailAdress.getText())){
            emailAdress.setError("Please provide a valid address");
            emailAdress.requestFocus();
            return;
        }
        else{
            if(password.length() < 6){
                password.setError("Enter a password longer than 6 characters");
                password.requestFocus();
                return;
            }
        }


        mAuth.createUserWithEmailAndPassword(emailAdress.getText().toString(),password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                           @Override
                                           public void onComplete(@NonNull Task<AuthResult> task) {
                                               if(task.isSuccessful()){
                                                   startActivity(getIntent(emailAdress.getText().toString(),CSGOWelcome.class));
                                               }
                                               else{
                                                   emailAdress.setError("User already exists");
                                                   emailAdress.requestFocus();
                                               }
                                           }
                                       }
                );
    }

    private Intent getIntent(String emailAdress,Class page){
        Intent intent = new Intent(this, page);
        final Bundle extras = new Bundle();
        extras.putString("email",emailAdress);
        intent.putExtras(extras);
        return intent;
    }
}