package com.example.smarthomegestures;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.session.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SecondScreen extends AppCompatActivity {

    VideoView videoView;
    String gestureSelected;

    private static final String TAG = "SecondScreen";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen_layout);
        Log.d(TAG, "onCreate: Starting.");

        Button btnNavBack = (Button) findViewById(R.id.back);
        Button btnNavToCapture = (Button) findViewById(R.id.capture);

        btnNavBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnNavBack.");

                Intent intent = new Intent(SecondScreen.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });

        btnNavToCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnCapture.");
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                startActivity(intent);
            }
        });

        videoView = findViewById(R.id.gestureVideos);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

//        ScrollingActivity.getInstance().mapping(ScrollingActivity.getInstance().item);
//        gestureSelected = ScrollingActivity.getInstance().getGestureSelected();
//        int videoId = ScrollingActivity.getInstance().videoMap.get(gestureSelected);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.h_fanon));
        videoView.start();
    }
}
