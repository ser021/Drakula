package com.example.drakulaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SymptomsMoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_mood);

        Button btnSaveSymptoms = findViewById(R.id.btnSaveSymptoms);

        btnSaveSymptoms.setOnClickListener(v -> {
            // Save selected symptoms
            Toast.makeText(this, "Symptoms Saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}

