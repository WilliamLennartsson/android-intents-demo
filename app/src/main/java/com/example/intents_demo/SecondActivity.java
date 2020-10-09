package com.example.intents_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String RETURNED_DATA_KEY = "RETURNED_DATA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get textview from xml
        TextView tv = findViewById(R.id.displayMessageTextView);

        // Get intent from mainActivity
        Intent intent = getIntent();
        // Get data from intent
        String message = intent.getStringExtra(MainActivity.MESSAGE_KEY);

        // Display the message in textview
        tv.setText(message);
    }

    // Send back information to MainActivity
    public void sendBackBtnPressed(View view) {
        // Create intent
        Intent sendBackIntent = new Intent();
        // Add data to intent
        String message = "Detta kommer från SecondActivity";
        sendBackIntent.putExtra(RETURNED_DATA_KEY, message);
        // Set intent to be the result
        setResult(RESULT_OK, sendBackIntent);
        // Close this activity
        finish();
    }
}



