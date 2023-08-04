package com.example.smarthomegestures;

import android.content.Intent;
import android.icu.text.DisplayContext;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.smarthomegestures.databinding.ActivityScrollingBinding;

import java.util.HashMap;

public class ScrollingActivity extends AppCompatActivity {

    String[] item = {"Gesture - 8", "Gesture - 7", "Set Thermostat to specified temperature", "Gesture - 9",
            "Turn Off Light",  "Decrease Fan Speed", "Turn Off Fan", "Turn on Fan", "Gesture - 0", "Increase Fan Speed",
            "Turn On Light", "Gesture - 2", "Gesture - 1",  "Gesture - 4", "Gesture - 3", "Gesture - 6",  "Gesture - 5",
             };

    HashMap<String, Integer> videoMap = new HashMap<>();

    String gestureSelected;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    private ActivityScrollingBinding binding;

    private static ScrollingActivity instance;

//    CountDownTimer timer = new CountDownTimer(5000, 1000) {
//        @Override
//        public void onTick(long millisUntilFinished) {
//
//        }
//
//        @Override
//        public void onFinish() {
//             Intent intent = new Intent(stopService(takeVideoIntent));
//        }
//    }.start();

    private static final String TAG = "ScrollingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "onCreate: Starting.");

        Button btnNavToSecond = (Button) findViewById(R.id.goToNextScreen);

        btnNavToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnNavToSecond.");

                Intent intent = new Intent(ScrollingActivity.this, SecondScreen.class);
                startActivity(intent);
            }
        });

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapterItems.getItem(position).toString();
                gestureSelected = item;
                Toast.makeText(ScrollingActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();


            }
        });

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());


    }

    public static ScrollingActivity getInstance() {
        return instance;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mapping(String[] input) {
        Integer idx = R.raw.h_8;
        for (String i : input) {
            videoMap.put(i, idx++);
        }
    }

    public String getGestureSelected() {
        return gestureSelected;
    }
}