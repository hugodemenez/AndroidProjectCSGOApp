package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.HashMap;

import java.util.Map;

import api.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CSGOLogin extends AppCompatActivity {
    private EditText emailAddress;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        emailAddress = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and go to welcome screen if user is logged in.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            new CSGOActivityStarter(this,CSGOWelcome.class);
        }
        callAPI();
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
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        new CSGOActivityStarter(context,CSGOWelcome.class);
                    } else {
                        password.setError("Wrong password");
                        password.requestFocus();
                    }
                });

        mAuth.createUserWithEmailAndPassword(emailAddress.getText().toString(),password.getText().toString())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Map<String,String> extras = new HashMap<String,String>() {{
                            put("email",emailAddress.getText().toString());
                        }};
                        new CSGOActivityStarter(context,extras,CSGOWelcome.class);
                    }
                }
                );
    }

    public void onClickSign(View view) {
        Map<String,String> extras = new HashMap<String,String>() {{
            put("email",emailAddress.getText().toString());
        }};
        new CSGOActivityStarter(this,extras,CSGOSign.class);
    }

    public void onClickReset(View view) {
        Map<String,String> extras = new HashMap<String,String>() {{
            put("email",emailAddress.getText().toString());
        }};
        new CSGOActivityStarter(this,extras,CSGOReset.class);
    }

    void callAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.quotable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        service.getQuote("random").enqueue(new Callback<String>() {
            // Response retrieved
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String>response) {
                String quote = response.body();
                if (quote != null){
                    Log.e("RESPONSE API", quote);
                    emailAddress.setText(quote);
                } else {
                    Log.e("RESPONSE API", "Response null");
                }
            }
            // Failure callback
            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("RESPONSE API", "Failure callback");
            }
        });
    }


}