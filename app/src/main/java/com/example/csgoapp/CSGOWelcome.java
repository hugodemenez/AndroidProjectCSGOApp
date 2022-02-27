package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import api.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CSGOWelcome extends AppCompatActivity {
    private TextView apiQuote;
    private TextView apiAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomelayout);

        apiQuote = findViewById(R.id.apiQuote);
        apiAuthor = findViewById(R.id.apiAuthor);

        // Initialize Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // If not logged in, finish current activity, and go to login screen
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            finish();
        }

        callAPI();
    }

    public void onClickLogout(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
    }

    void callAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.quotable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        service.getQuote().enqueue(new Callback<Quote>() {
            // Response retrieved
            @Override
            public void onResponse(@NonNull Call<Quote> call, @NonNull Response<Quote> response) {
                Quote quote = response.body();
                if (quote != null){
                    Log.e("RESPONSE API", quote.getContent());
                    apiQuote.setText(quote.getContent());
                    apiAuthor.setText(quote.getAuthor());
                } else {
                    Log.e("RESPONSE API", "Response null");
                }
            }
            // Failure callback
            @Override
            public void onFailure(@NonNull Call<Quote> call, @NonNull Throwable t) {
                Log.e("RESPONSE API", "Failure callback");
            }
        });
    }

    public void onClickSpotGuide(View view){
        new CSGOActivityStarter(this,CSGOChoose.class);
    }
}