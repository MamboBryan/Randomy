package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanks.htextview.scale.ScaleText;
import com.hanks.htextview.scale.ScaleTextView;
import com.scwang.wave.MultiWaveHeader;

import java.util.Random;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import io.saeid.fabloading.LoadingView;

public class MainActivity extends AppCompatActivity {

    private int minimumRangeValue;
    private int maximumRangeValue;
    private TextView randomNumberDisplay;
    private ScaleTextView scaleRandomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCenter.start(getApplication(), "8df8b2cc-1b91-442d-888c-beae3706ce58",
                Analytics.class, Crashes.class);

        randomNumberDisplay = findViewById(R.id.textView_random_number_display);
        scaleRandomText = findViewById(R.id.randomScale);

        Intent myIntent = getIntent();
        minimumRangeValue = Integer.parseInt(myIntent.getStringExtra("minimumRangeValue"));
        maximumRangeValue = Integer.parseInt(myIntent.getStringExtra("maximumRangeValue"));

        scaleRandomText.setVisibility(View.INVISIBLE);
        displayRandomNumber();

        Button regenerateButton = findViewById(R.id.button_regenerate);
        regenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleRandomText.setVisibility(View.VISIBLE);
                randomNumberDisplay.setVisibility(View.INVISIBLE);
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
        scaleRandomText.animateText(String.valueOf(myNumber));
    }

    /*
     *Generates random number
     */
    private int generateRandomNumber(int minimum, int maximum) {
        Random rand = new Random();
        return rand.nextInt(maximum - minimum) + 1 + minimum;
    }

}
