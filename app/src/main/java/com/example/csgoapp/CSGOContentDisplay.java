package com.example.csgoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;




public class CSGOContentDisplay extends AppCompatActivity {


    private ImageView image1View;
    private ImageView image2View;
    private YouTubePlayerView videoView;
    private TextView instructionView;

    private String videoID;

    private String videoURL;
    private String image1URL;
    private String image2URL;
    private String instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentdisplaylayout);

        final Intent intent = getIntent();
        if(null!=intent){
            final Bundle extras = intent.getExtras();
            if(null!=extras){
                videoURL = extras.getString("videoUrl");
                image1URL = extras.getString("image1Url");
                image2URL = extras.getString("image2Url");
                instruction = extras.getString("instruction");
            }
            else{
                Log.e("Extras","empty");
            }
        }
        else{
            Log.e("Intent","empty");
        }

        // Declaring and initializing the ImageView
        image1View = findViewById(R.id.image1View);
        // Declaring and initializing the ImageView
        image2View = findViewById(R.id.image2View);
        //// Declaring and initializing the TextView
        instructionView = findViewById(R.id.instruction);
        instructionView.setText(instruction);


        Glide.with(this).load(image1URL).into(image1View);
        Glide.with(this).load(image2URL).into(image2View);



        // Bind the player to the view.
        videoView = findViewById(R.id.videoView);
        getLifecycle().addObserver(videoView);

        // Assign video id to be load
        videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String id = videoURL.split("=")[1];
                Log.w("Video ID",id);
                youTubePlayer.loadVideo(id, 0);
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
