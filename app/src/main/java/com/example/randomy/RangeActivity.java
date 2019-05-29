package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.androidslidr.Slidr;

public class RangeActivity extends AppCompatActivity {

    private Slidr minimumSeekBarSlidr;
    private TextView minimumTextViewValue;

    int minimumRangeValue = 0;
    int maximumRangeValue = 100;

    private Slidr maximumSeekBarSlidr;
    private TextView maximumTextViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);

        //get minimum SeekBar and TexView views and assign to variable
        //Set minimum and maximum values for the minimum SeekBar
        //Note SeekBar change and set it to the TextView
        minimumSeekBarSlidr = findViewById(R.id.seekbar_minimum_value);
        minimumTextViewValue = findViewById(R.id.textView_random_number_minimum);
        minimumSeekBarSlidr.setMin(minimumRangeValue);
        minimumSeekBarSlidr.setMax(maximumRangeValue);
        minimumSeekBarSlidr.setCurrentValue(50);
        minimumTextViewValue.setText(String.valueOf(
                Math.round(minimumSeekBarSlidr.getCurrentValue())));

        /*
         * Get maximum SeekBar and TexView views and assign to variable
         * Set minimum and maximum values for the maximum SeekBar
         * Note SeekBar change and set it to the TextView
         */
        maximumSeekBarSlidr = findViewById(R.id.seekbar_maximum_value);
        maximumTextViewValue = findViewById(R.id.textView_random_number_maximum);
        maximumSeekBarSlidr.setMin(minimumRangeValue);
        maximumSeekBarSlidr.setMax(maximumRangeValue);
        maximumSeekBarSlidr.setCurrentValue(100);
        maximumTextViewValue.setText(String.valueOf(
                Math.round(maximumSeekBarSlidr.getCurrentValue())));

        setProgressChangeListener(minimumSeekBarSlidr, minimumTextViewValue);
        setProgressChangeListener(maximumSeekBarSlidr, maximumTextViewValue);

        /*
         * This finds the button and assigns it to a variable
         * Sets an onClick listener to open an intent to the MainActivity
         * Also puts two extras of Minimum and Maximum number range
         */
        Button generateButton = findViewById(R.id.button_generate_random_number);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RangeActivity.this, MainActivity.class);
                myIntent.putExtra("minimumRangeValue", minimumTextViewValue.getText().toString());
                myIntent.putExtra("maximumRangeValue", maximumTextViewValue.getText().toString());

                if (numbersAreNotEqual(minimumTextViewValue, maximumTextViewValue)) {

                    startActivity(myIntent);

                } else {
                    Toast toast = Toast.makeText(RangeActivity.this,
                            "Numbers cannot be equal", Toast.LENGTH_SHORT);
                    toast.setGravity(
                            Gravity.CENTER, 0, 0);
                    toast.show();
                }


            }
        });

    }

    private boolean numbersAreNotEqual(TextView minimumText, TextView maximumText) {

        int minimum = Integer.parseInt(minimumText.getText().toString());
        int maximum = Integer.parseInt(maximumText.getText().toString());

        if (minimum >= maximum) {
            return false;
        }

        return true;
    }

    /*
     * This method takes the slidr and TextView as parameters
     * It then notes the change of the slidr and updates the textView with the progress value
     */
    private void setProgressChangeListener(Slidr seekBarSlidr, final TextView textView) {
        seekBarSlidr.setListener(new Slidr.Listener() {
            @Override
            public void valueChanged(Slidr slidr, float currentValue) {
                textView.setText(String.valueOf(Math.round(currentValue)));
            }

            @Override
            public void bubbleClicked(Slidr slidr) {

            }
        });
    }
}
