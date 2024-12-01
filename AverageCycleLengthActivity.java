package com.example.drakulaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AverageCycleLengthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_cycle_length);

        TextView averageCycleLength = findViewById(R.id.averageCycleLength);

        int[] cycleLengths = {28, 27, 29, 26};
        int total = 0;

        for (int cycle : cycleLengths) {
            total += cycle;
        }

        int average = total / cycleLengths.length;
        averageCycleLength.setText(average + " days");
    }
}

