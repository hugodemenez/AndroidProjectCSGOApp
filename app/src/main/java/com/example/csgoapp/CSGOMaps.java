package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class CSGOMaps extends AppCompatActivity {

    private ImageButton buttonMapInferno;
    private ImageButton buttonMapMirage;
    private ImageButton buttonMapCobblestone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapslayout);
        buttonMapInferno = findViewById(R.id.buttonInferno);
        buttonMapMirage = findViewById(R.id.buttonMirage);
        buttonMapCobblestone = findViewById(R.id.buttonCobblestone);

    }

    public void onClickBackButton(View view) {
        finish();
    }

    public void onClickLogout(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, CSGOLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void buttonPress(View v) {
        String map = "";
        switch (v.getId()) {
            case R.id.buttonInferno : map = "Inferno";break;
            case R.id.buttonMirage : map = "Mirage";break;
            case R.id.buttonCobblestone : map = "Cobblestone";break;
        }

        String finalMap = map;
        Map<String,String> extras = new HashMap<String,String>() {{
            put("map", finalMap);
        }};

        new CSGOActivityStarter(this,extras,CSGOChoose.class);
    }


}