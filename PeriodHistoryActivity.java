package com.example.drakulaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PeriodHistoryActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_history);

        ListView listPeriodHistory = findViewById(R.id.listPeriodHistory);

        String[] periodDates = {
                "2024-11-01 to 2024-11-06",
                "2024-10-02 to 2024-10-07",
                "2024-09-03 to 2024-09-08"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, periodDates);

        listPeriodHistory.setAdapter(adapter);
    }
}

