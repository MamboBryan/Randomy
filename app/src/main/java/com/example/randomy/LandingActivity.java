package com.example.randomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        AppCenter.start(getApplication(), "8df8b2cc-1b91-442d-888c-beae3706ce58",
                Analytics.class, Crashes.class);

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
