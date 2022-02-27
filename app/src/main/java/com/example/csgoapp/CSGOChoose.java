package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CSGOChoose extends AppCompatActivity {
    private Spinner spinnerSide;
    private Spinner spinnerGrenade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooselayout);

        spinnerSide = (Spinner) findViewById(R.id.spinnerSide);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.side, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSide.setAdapter(adapter);

        spinnerGrenade = (Spinner) findViewById(R.id.spinnerGrenade);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterGrenade = ArrayAdapter.createFromResource(this,
                R.array.grenadeType, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterGrenade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerGrenade.setAdapter(adapterGrenade);

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

    public void onClickAddContent(View view) {
        Map<String,String> extras = new HashMap<String,String>() {{
            put("side",spinnerSide.getSelectedItem().toString());
            put("grenade",spinnerGrenade.getSelectedItem().toString());
        }};
        new CSGOActivityStarter(this,extras,addcontentlayout.class);
    }
}