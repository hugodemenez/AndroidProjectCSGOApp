package com.example.csgoapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CSGOReset extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetlayout);
        emailAddress = findViewById(R.id.editTextEmailAddress);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and go to welcome screen if user is logged in.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            new CSGOActivityStarter(this,CSGOWelcome.class);
        }


        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                final String email = extras.getString("email");
                emailAddress.setText(email);
            }
        }
    }


    public void onClickReset(View view){
        mAuth = FirebaseAuth.getInstance();
        Context context = this;

        String email = emailAddress.getText().toString();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(context, "Reset email instructions sent to " + email + " it can take up to 5 minutes", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, email + " does not exist", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClickBackButton(View view){
        finish();
    }
}