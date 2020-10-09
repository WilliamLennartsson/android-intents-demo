package com.example.intents_demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String MESSAGE_KEY = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Button OnClick method
    public void buttonPressed(View view) {
        // Log.d("WILL", "Button pressed!!");
        // Create intent with context and destination activity
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        String message = "Hej från MainActivity";
        // Add data to intent
        secondActivityIntent.putExtra(MESSAGE_KEY, message);
        secondActivityIntent.putExtra("HIGHSCORE_KEY", 193);
        // Start activity with intent
        // startActivity(secondActivityIntent);
        startActivityForResult(secondActivityIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check requestCode
        if (requestCode == 1) {
            // Check resultCode
            if (resultCode == RESULT_OK) {
                // Check so that data isnt null
                if (data != null){
                    // Get string from the returned intent
                    String returnedString = data.getStringExtra(SecondActivity.RETURNED_DATA_KEY);
                    Log.d("WILL", returnedString);
                }
            }
        }
    }

}




