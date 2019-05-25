package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int minimumRangeValue;
    private int maximumRangeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent myIntent = getIntent();
        minimumRangeValue = Integer.parseInt(myIntent.getStringExtra("minimumRangeValue"));
        maximumRangeValue = Integer.parseInt(myIntent.getStringExtra("maximumRangeValue"));

        setRangeValues(minimumRangeValue, maximumRangeValue);
    }

    public void setRangeValues(int minimumValue, int maximumValue) {
        TextView minimumDisplay = findViewById(R.id.textView_display_range_minimum);
        TextView maximumDisplay = findViewById(R.id.textView_display_range_maximum);

        minimumDisplay.setText(String.valueOf(minimumValue));
        maximumDisplay.setText(String.valueOf(maximumValue));
    }
}
