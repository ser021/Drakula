package com.example.drakulaapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class PTActivity extends AppCompatActivity {

    private PeriodTracker tracker;
    private Button addStartDateButton, addEndDateButton, showCycleLengthButton, predictNextPeriodButton, showHistoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView); // Replace with your actual ID for the "Welcome NAME" TextView

        String userName = getIntent().getStringExtra("USER_NAME");

        if (userName != null && !userName.isEmpty()) {
            welcomeTextView.setText("Welcome " + userName);
        } else {
            welcomeTextView.setText("Welcome!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_tracking);

        tracker = ((UserAcct) getIntent().getSerializableExtra("user")).getTracker();

        addStartDateButton = findViewById(R.id.addStartDateButton);
        addEndDateButton = findViewById(R.id.addEndDateButton);
        showCycleLengthButton = findViewById(R.id.showCycleLengthButton);
        predictNextPeriodButton = findViewById(R.id.predictNextPeriodButton);
        showHistoryButton = findViewById(R.id.showHistoryButton);

        addStartDateButton.setOnClickListener(view -> {
            // You would use a date picker here to allow the user to select the date
            LocalDate startDate = LocalDate.now(); // This is just a placeholder
            tracker.addPeriodStart(startDate);
            Toast.makeText(PeriodTrackingActivity.this, "Start date added", Toast.LENGTH_SHORT).show();
        });

        addEndDateButton.setOnClickListener(view -> {
            // Same with the end date
            LocalDate endDate = LocalDate.now(); // Placeholder
            tracker.addPeriodEnd(endDate);
            Toast.makeText(PeriodTrackingActivity.this, "End date added", Toast.LENGTH_SHORT).show();
        });

        showCycleLengthButton.setOnClickListener(view -> {
            double avgCycle = tracker.getAvgCycleLength();
            Toast.makeText(PeriodTrackingActivity.this, "Average cycle length: " + avgCycle, Toast.LENGTH_SHORT).show();
        });

        predictNextPeriodButton.setOnClickListener(view -> {
            LocalDate nextPeriod = tracker.predictNextPeriod();
            if (nextPeriod != null) {
                Toast.makeText(PeriodTrackingActivity.this, "Next period: " + nextPeriod, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PeriodTrackingActivity.this, "Not enough data", Toast.LENGTH_SHORT).show();
            }
        });

        showHistoryButton.setOnClickListener(view -> {
            // Show period history
            Toast.makeText(PeriodTrackingActivity.this, "Period history displayed here", Toast.LENGTH_SHORT).show();
        });
    }
}
