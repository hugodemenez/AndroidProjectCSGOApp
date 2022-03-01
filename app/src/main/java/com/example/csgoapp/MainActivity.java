package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addToDb( "",
        "",
        "",
        "",
        "",
        "",
        ""
        );



    }


    public void addToDb(String map, String grenade,String side,String contentTitle,String videoUrl,String image1Url,String image2Url){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        Map<String, Object> content = new HashMap<>();
        content.put("map", map);
        content.put("grenade", grenade);
        content.put("side", side);
        content.put("contentTitle", contentTitle);
        content.put("videoUrl", videoUrl);
        content.put("image1Url", image1Url);
        content.put("image2Url", image2Url);

        // Add a new document with a generated ID
        db.collection("contents")
                .add(content)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("OK", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("OK", "Error adding document", e);
                    }
                });
    }
}