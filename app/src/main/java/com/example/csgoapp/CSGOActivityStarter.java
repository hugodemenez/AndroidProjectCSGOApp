package com.example.csgoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public class CSGOActivityStarter extends AppCompatActivity{

    public CSGOActivityStarter(Context context, Map<String,String> extrasToBundle, Class<?> page){
        startNewActivity(context,extrasToBundle,page);
    }

    public CSGOActivityStarter(Context context, Class<?> page){
        startNewActivity(context,null,page);
    }

    public void startNewActivity(Context context, Map<String,String> extrasToBundle, Class<?> page){
        Intent intent = new Intent(context, page);

        //Iterate over elements in dictionary
        System.out.println("Iterating using enumeration:");
        if(extrasToBundle!=null){
            final Bundle bundle = new Bundle();
            Iterator<String> element = extrasToBundle.values().iterator();
            Iterator<String>  key = extrasToBundle.keySet().iterator();
            while(element.hasNext()){
                bundle.putString(key.next(),element.next());
                intent.putExtras(bundle);
            }
        }
        context.startActivity(intent);
    }



}
