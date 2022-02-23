package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CSGOLogin extends AppCompatActivity {

    private EditText emailAdress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        emailAdress = (EditText) findViewById(R.id.editTextEmail);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void onClickLogin(View view) {


        if(TextUtils.isEmpty(emailAdress.getText())){
            Toast.makeText(this,"Type your mail !",Toast.LENGTH_LONG).show();
            Log.e("email : ",emailAdress.getText().toString());
        }

        else{

        }
    }

    public void onClickSignin(View view) {
        startActivity(getIntent(emailAdress.getText().toString()));
    }


    private Intent getIntent(String emailAdress){
        Intent intent = new Intent(this, CSGOSign.class);
        final Bundle extras = new Bundle();
        extras.putString("email",emailAdress);
        intent.putExtras(extras);
        return intent;
    }


}