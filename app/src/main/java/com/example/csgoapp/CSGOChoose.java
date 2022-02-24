package com.example.csgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CSGOChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooselayout);

        Spinner spinnerSide = (Spinner) findViewById(R.id.spinnerSide);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.side, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSide.setAdapter(adapter);

        Spinner spinnerGrenade = (Spinner) findViewById(R.id.spinnerGrenade);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterGrenade = ArrayAdapter.createFromResource(this,
                R.array.grenadeType, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterGrenade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerGrenade.setAdapter(adapterGrenade);
    }



}