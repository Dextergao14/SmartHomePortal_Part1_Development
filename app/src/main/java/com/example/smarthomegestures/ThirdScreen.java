package com.example.smarthomegestures;

import android.content.Intent;
import android.graphics.Camera;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class ThirdScreen extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE = 51;
    private static final String TAG = "ThirdScreen";
    VideoView videoView;
//    Camera mCamera = new Camera();
    Uri videoUri;
//    MediaRecorder recorder;

//    CountDownTimer timer = new CountDownTimer(5000, 1000) {
//        @Override
//        public void onTick(long millisUntilFinished) {
//
//        }
//
//        @Override
//        public void onFinish() {
//            stopService(dispatchTakeVideoIntent());
//        }
//    }.start();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen_layout);
        Log.d(TAG, "onCreate: Starting.");

        Button btnDone = (Button) findViewById(R.id.upload);
        Button btnUpload = (Button) findViewById(R.id.undo);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnDone.");

                Intent intent = new Intent(ThirdScreen.this, ScrollingActivity.class);
//                recorder.stop();
//                recorder.reset();
//                recorder.release();
                startActivity(intent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnUpload.");

                Intent intent = new Intent(ThirdScreen.this, ThirdScreen.class);
                startActivity(intent);

            }

        });

//        timer.start();
        dispatchTakeVideoIntent();

        videoView = findViewById(R.id.recordedVideos);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(videoUri);
        videoView.start();

    }


    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
//            recorder.start();
//            videoUri = takeVideoIntent.getData();

//            recorder.setVideoSource(REQUEST_VIDEO_CAPTURE);
//            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//            recorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
//            recorder.setVideoEncodingBitRate(512 * 1024);
//            recorder.setVideoFrameRate(30);
//            recorder.setOrientationHint(270);
//            recorder.setVideoSize(388, 469);

        } else {
            throw new RuntimeException("A error has occurred.");
        }
    }




}
