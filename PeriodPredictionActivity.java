package com.example.drakulaapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PeriodPredictionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_prediction);

        CalendarView calendarView = findViewById(R.id.calendarPeriodPrediction);

        calendarView.setDate(System.currentTimeMillis(), false, true);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Toast.makeText(this, "Prediction for: " + (month + 1) + "/" + dayOfMonth + "/" + year, Toast.LENGTH_SHORT).show();
        });
    }
}

