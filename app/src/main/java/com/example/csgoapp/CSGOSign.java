package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CSGOSign extends AppCompatActivity {

    private EditText emailAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signlayout);
        emailAdress = (EditText) findViewById(R.id.editTextEmail);

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
        startActivity(getIntent(emailAdress.getText().toString()));
    }


    private Intent getIntent(String emailAdress){
        Intent intent = new Intent(this, CSGOLogin.class);
        final Bundle extras = new Bundle();
        extras.putString("email",emailAdress);
        intent.putExtras(extras);
        return intent;
    }
}