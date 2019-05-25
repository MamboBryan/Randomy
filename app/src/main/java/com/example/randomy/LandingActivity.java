package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //find start button and set it to the button variable
        Button startButton = findViewById(R.id.button_start);

        //Set onClick listener for the button to open new activity
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRangeActivity();
            }
        });


    }

    /*
        Method to open rangeActivity
     */
    private void openRangeActivity() {
        Intent myIntent = new Intent(this, RangeActivity.class);
        startActivity(myIntent);
    }
}
