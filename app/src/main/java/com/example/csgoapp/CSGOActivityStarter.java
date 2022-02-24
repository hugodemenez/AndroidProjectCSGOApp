package com.example.csgoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Dictionary;
import java.util.Enumeration;

public class CSGOActivityStarter extends AppCompatActivity{

    public void startNewActivity(Context context, Dictionary<String,String> extrasToBundle, Class page){
        Intent intent = new Intent(context, page);
        final Bundle bundle = new Bundle();

        //Iterate over elements in dictionary
        System.out.println("Iterating using enumeration:");
        Enumeration<String> e = extrasToBundle.elements();
        Enumeration<String> ekey = extrasToBundle.keys();
        while(e.hasMoreElements())
            System.out.print(e.nextElement() + " ");
        bundle.putString(ekey.nextElement(),e.nextElement());
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void startNewActivity(Context context, Class page){
        Intent intent = new Intent(context, page);
        startActivity(intent);
    }

}
