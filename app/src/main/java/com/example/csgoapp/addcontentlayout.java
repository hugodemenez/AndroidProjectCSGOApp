package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class addcontentlayout extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String grenade = "";
    private String side = "";
    private String map = "";
    private EditText contentTitle;
    private EditText videoUrl;
    private EditText image1Url;
    private EditText image2Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontentlayout);
        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                grenade = extras.getString("grenade");
                side = extras.getString("side");
                map = extras.getString("map");
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
        content.put("map", map);
        content.put("grenade", grenade);
        content.put("side", side);
        content.put("contentTitle", contentTitle.getText().toString());
        content.put("videoUrl", videoUrl.getText().toString());
        content.put("image1Url", image1Url.getText().toString());
        content.put("image2Url", image2Url.getText().toString());

        // Check if content is already in db
        db.collection("contents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // Create a new user with a first and last name
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                if(contentTitle.getText().toString().equals((String)document.getData().get("contentTitle")) || videoUrl.getText().toString().equals((String)document.getData().get("videoUrl")))
                                {
                                    Toast.makeText(addcontentlayout.this, "Content already in DB", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            // Add a new document with a generated ID
                            db.collection("contents")
                                    .add(content)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d("OK", "DocumentSnapshot added with ID: " + documentReference.getId());
                                            Toast.makeText(addcontentlayout.this, "Content successfully added", Toast.LENGTH_SHORT).show();
                                            contentTitle.setText("");
                                            videoUrl.setText("");
                                            image1Url.setText("");
                                            image2Url.setText("");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("OK", "Error adding document", e);
                                            Toast.makeText(addcontentlayout.this, "Unable to add new content", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            Log.d("Database Get", "Error getting documents: ", task.getException());
                        }
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