package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class CSGOReset extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetlayout);
    }


    public void onClickReset(View view){
        mAuth = FirebaseAuth.getInstance();
        Context context = this;
        emailAddress = (EditText) findViewById(R.id.editTextEmailAddress);
        String email = emailAddress.getText().toString();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "Reset email instructions sent to " + email, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, email + " does not exist", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}