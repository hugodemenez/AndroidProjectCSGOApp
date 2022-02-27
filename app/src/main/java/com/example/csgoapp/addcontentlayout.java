package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addcontentlayout extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String grenade = "";
    private String side = "";
    private EditText contentTitle;
    private EditText videoUrl;
    private EditText image1Url;
    private EditText image2Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontentlayout);
        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                grenade = extras.getString("grenade");
                side = extras.getString("side");
            }
        }

    }

    public void addContent(View view){
        videoUrl = findViewById(R.id.editTextVideoUrl);
        image1Url = findViewById(R.id.editTextImage1Url);
        image2Url = findViewById(R.id.editTextImage2Url);
        contentTitle = findViewById(R.id.editTextContentTitle);
        // Create a new user with a first and last name
        Map<String, Object> content = new HashMap<>();
        content.put("map", "Inferno");
        content.put("grenade", grenade);
        content.put("side", side);
        content.put("contentTitle", contentTitle.getText().toString());
        content.put("videoUrl", videoUrl.getText().toString());
        content.put("image1Url", image1Url.getText().toString());
        content.put("image2Url", image2Url.getText().toString());

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
}