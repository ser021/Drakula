package com.example.drakulaapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartDateActivity extends AppCompatActivity {

    private long selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_date);

        CalendarView calendarView = findViewById(R.id.calendarViewStartDate);
        Button btnSaveStartDate = findViewById(R.id.btnSaveStartDate);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            selectedDate = calendar.getTimeInMillis();
        });

        btnSaveStartDate.setOnClickListener(v -> {
            // Save selectedDate to shared preferences or database
            Toast.makeText(this, "Start Date Saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}

