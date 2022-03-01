package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CSGOChoose extends AppCompatActivity {
    private Spinner spinnerSide;
    private Spinner spinnerGrenade;
    private RecyclerView recyclerView;
    private String map;
    private TextView mapName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooselayout);
        mapName = findViewById(R.id.mapName);

        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                map = extras.getString("map");
                mapName.setText(map);
            }
        }

        spinnerSide = findViewById(R.id.spinnerSide);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.side, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSide.setAdapter(adapter);

        spinnerGrenade = findViewById(R.id.spinnerGrenade);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterGrenade = ArrayAdapter.createFromResource(this,
                R.array.grenadeType, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterGrenade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerGrenade.setAdapter(adapterGrenade);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        // Apply the adapter to the recyclerView when database is fully loaded
        addContentFromDatabaseToAdapter();
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
            put("map",map);
        }};
        new CSGOActivityStarter(this,extras,addcontentlayout.class);
    }

    List<Content> contents = new ArrayList<Content>();

    public void addContentFromDatabaseToAdapter(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Context context = this;
        db.collection("contents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // Create a new user with a first and last name
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                if(spinnerSide.getSelectedItem().toString().equals((String)document.getData().get("side"))
                                        && spinnerGrenade.getSelectedItem().toString().equals((String)document.getData().get("grenade"))
                                            && map.equals((String)document.getData().get("map"))
                                ){
                                    contents.add(new Content(
                                            (String)document.getData().get("map"),
                                            (String)document.getData().get("grenade"),
                                            (String)document.getData().get("side"),
                                            (String)document.getData().get("contentTitle"),
                                            (String)document.getData().get("videoUrl"),
                                            (String)document.getData().get("image1Url"),
                                            (String)document.getData().get("image2Url")
                                            ));
                                }
                            }
                            recyclerView.setAdapter(new RecyclerViewAdapter(contents,context));
                        } else {
                            Log.d("Database Get", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
}