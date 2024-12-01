package com.example.drakulaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainApp extends AppCompatActivity {

    private UserManager userMng;
    private Button loginButton, createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userMng = new UserMngImpl();

        TextView textView = findViewById(R.id.welcomeTextView);
        textView.setText("Welcome to");
        TextView textView2 = findViewById(R.id.drakulaTextView);
        textView2.setText("Drakula");
        loginButton = findViewById(R.id.loginButton);
        createButton = findViewById(R.id.createButton);

        loginButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString().trim();
            if (userMng.userExists(name)) {
                UserAcct user = userMng.getUser(name);
                Intent intent = new Intent(MainActivity.this, PeriodTrackingActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
            }
        });

        createButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString().trim();
            if (!name.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, AccountCreationActivity.class);
                intent.putExtra("userName", name);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
