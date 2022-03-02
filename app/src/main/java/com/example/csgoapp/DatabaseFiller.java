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

public class DatabaseFiller   {


    public DatabaseFiller(){

        addToDb( "Inferno",
        "Smokes",
        "Terrorists",
        "Banana to deep CT",
        "https://www.youtube.com/watch?v=qwKYv0fMX5I",
        "https://i.ibb.co/479g1Cp/20220227174205-1.jpg",
        "https://i.ibb.co/Fs2y0Sf/20220301190156-1.jpg",
                "Throw"

        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Banana to coffin",
                "https://www.youtube.com/watch?v=pZBR6CXfCVQ",
                "https://i.ibb.co/GFhdvty/20220227173904-1.jpg",
                "https://i.ibb.co/z6XpdrK/20220227173849-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Banana cross pool",
                "https://www.youtube.com/watch?v=l3GK8czdSv8",
                "https://i.ibb.co/n6G3DvH/20220227174058-1.jpg",
                "https://i.ibb.co/chYwGhJ/20220227174118-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Mid to plane",
                "https://www.youtube.com/watch?v=mapt01PeIqM",
                "https://i.ibb.co/jRyq0QR/20220227180245-1.jpg",
                "https://i.ibb.co/xXQzHpy/20220227184602-1.jpg",
                "Trow"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Pit to plane",
                "https://www.youtube.com/watch?v=WuloTQe7Nd0",
                "https://i.ibb.co/6Fc0qNH/20220227180421-1.jpg",
                "https://i.ibb.co/GR81xCq/20220227180351-1.jpg",
                "JumpThrow"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Mid to long",
                "https://www.youtube.com/watch?v=d4VSBGPoE5E",
                "https://i.ibb.co/MCTnqX1/20220227180224-1.jpg",
                "https://i.ibb.co/4mqsBKk/20220227180125-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Mid to short",
                "https://www.youtube.com/watch?v=K4_x0S-pCmU",
                "https://i.ibb.co/MCTnqX1/20220227180224-1.jpg",
                "https://i.ibb.co/2vNb5XJ/20220227180123-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Terrorists",
                "Appart to balcony",
                "https://www.youtube.com/watch?v=5BcXp_dsW6w",
                "https://i.ibb.co/b3t38Xk/20220227180713-1.jpg",
                "https://i.ibb.co/Pxsn9F7/20220227180619-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Incendiary",
                "Terrorists",
                "Second mid to boost short",
                "https://www.youtube.com/watch?v=ZCuduQaMLw0",
                "https://i.ibb.co/V9Ng2v8/20220227180948-1.jpg",
                "https://i.ibb.co/cJRcmvC/20220227181018-1.jpg",
                "JumpThrow"
        );
        addToDb( "Inferno",
                "Incendiary",
                "Terrorists",
                "Corner long",
                "https://www.youtube.com/watch?v=fkUcuFWRRzI",
                "https://i.ibb.co/1bTSs26/20220227184349-1.jpg",
                "https://i.ibb.co/0jBJCfR/20220227180800-1.jpg",
                "Run & Throw"
        );
        addToDb( "Inferno",
                "Incendiary",
                "Terrorists",
                "Car to new box",
                "https://www.youtube.com/watch?v=H42BCUodvwc",
                "https://i.ibb.co/D1mNZQT/20220227181109-1.jpg",
                "https://i.ibb.co/hX4qRRd/20220227181404-1.jpg",
                "JumpThrow"
        );
        addToDb( "Inferno",
                "Incendiary",
                "Terrorists",
                "B sandwich",
                "https://www.youtube.com/watch?v=EqMZvwozzOE",
                "https://i.ibb.co/dfgNCNB/20220227181623-1.jpg",
                "https://i.ibb.co/mqBDbkH/20220227181647-1.jpg",
                "JumpThrow"
        );
        addToDb( "Inferno",
                "Incendiary",
                "Terrorists",
                "B Dark",
                "https://www.youtube.com/watch?v=1j3dDdrbl-w",
                "https://i.ibb.co/C5RbYbh/20220227181424-1.jpg",
                "https://i.ibb.co/7Y946X5/20220227181459-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Deep banana",
                "https://www.youtube.com/watch?v=Zko5STitbzo",
                "https://i.ibb.co/KG2zCdK/20220227181734-1.jpg",
                "https://i.ibb.co/MgbBz14/20220227181758-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Half wall banana",
                "https://www.youtube.com/watch?v=9ht3tzS-2sE",
                "https://i.ibb.co/cx3R17S/20220227181916-1.jpg",
                "https://i.ibb.co/CmcQFf9/20220227182118-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Cross B site",
                "https://www.youtube.com/watch?v=LUokz5ue8ho",
                "https://i.ibb.co/yQKcCNf/20220227182216-1.jpg",
                "https://i.ibb.co/cv3xSzG/20220301191821-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Retake A short",
                "https://www.youtube.com/watch?v=MQTvyYSxJDs",
                "https://i.ibb.co/hF3Gyp7/20220227182546-1.jpg",
                "https://i.ibb.co/pZ8dLwC/20220227182523-1.jpg",
                "Throw"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Mid from CT",
                "https://www.youtube.com/watch?v=JzT4sy7ipYQ",
                "https://i.ibb.co/V3449Ck/20220227182441-1.jpg",
                "https://i.ibb.co/N7pZBrL/20220227182420-1.jpg",
                "JumpThrow"
        );
        addToDb( "Inferno",
                "Smokes",
                "Counter-Terrorists",
                "Retake apartment",
                "https://www.youtube.com/watch?v=LQMNpAPUllU",
                "https://i.ibb.co/W3NxKqd/20220227182623-1.jpg",
                "https://i.ibb.co/WHYfR2G/20220227182641-1.jpg",
                "Throw"
        );
    }


    public void addToDb(String map, String grenade,String side,String contentTitle,String videoUrl,String image1Url,String image2Url, String inst){
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
        content.put("instruction", inst);

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