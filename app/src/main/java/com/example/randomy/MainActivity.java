package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int minimumRangeValue;
    private int maximumRangeValue;
    private TextView randomNumberDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberDisplay = findViewById(R.id.textView_random_number_display);

        Intent myIntent = getIntent();
        minimumRangeValue = Integer.parseInt(myIntent.getStringExtra("minimumRangeValue"));
        maximumRangeValue = Integer.parseInt(myIntent.getStringExtra("maximumRangeValue"));

        displayRandomNumber();

        Button regenerateButton = findViewById(R.id.button_regenerate);
        regenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomNumber();
            }
        });

        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, RangeActivity.class);
                startActivity(myIntent);
                

            }
        });

    }

    /*
     *Displays the random number generated and displays it to the textView
     */
    private void displayRandomNumber() {
        int myNumber = generateRandomNumber(minimumRangeValue, maximumRangeValue);
        randomNumberDisplay.setText(String.valueOf(myNumber));
    }

    /*
     *Generates random number
     */
    private int generateRandomNumber(int minimum, int maximum) {
        Random rand = new Random();
        return rand.nextInt(maximum - minimum) + 1 + minimum;
    }

}
