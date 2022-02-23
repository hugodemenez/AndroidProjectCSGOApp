package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailAdress;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        loginButton = (Button) findViewById(R.id.buttonLogin);
        emailAdress = (EditText) findViewById(R.id.editTextEmail);

        Log.e("email : ",emailAdress.getText().toString());
    }


    public void onClick(View view) {
        if(TextUtils.isEmpty(emailAdress.getText())){
            Toast.makeText(this,"emailAdress empty",Toast.LENGTH_LONG).show();
            return;
        }

    }

}