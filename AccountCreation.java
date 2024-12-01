package com.example.drakulaapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class AccountCreation extends AppCompatActivity {

    private EditText nameEditText, birthDateEditText, heightFeetEditText, heightInchesEditText, weightEditText;
    private Button createAccountButton;
    private UserManager userMng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        userMng = new UserMngImpl();

        nameEditText = findViewById(R.id.nameEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        heightFeetEditText = findViewById(R.id.heightFeetEditText);
        heightInchesEditText = findViewById(R.id.heightInchesEditText);
        weightEditText = findViewById(R.id.weightEditText);
        createAccountButton = findViewById(R.id.createAccountButton);

        createAccountButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString().trim();
            String birthDateStr = birthDateEditText.getText().toString().trim();
            String heightFeetStr = heightFeetEditText.getText().toString().trim();
            String heightInchesStr = heightInchesEditText.getText().toString().trim();
            String weightStr = weightEditText.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(birthDateStr) ||
                    TextUtils.isEmpty(heightFeetStr) || TextUtils.isEmpty(heightInchesStr) ||
                    TextUtils.isEmpty(weightStr)) {
                Toast.makeText(AccountCreationActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            LocalDate birthDate = LocalDate.parse(birthDateStr);
            int heightFeet = Integer.parseInt(heightFeetStr);
            int heightInches = Integer.parseInt(heightInchesStr);
            int weight = Integer.parseInt(weightStr);

            UserAcct userAcct = userMng.createUser(name, birthDate, heightFeet, heightInches, weight);
            Toast.makeText(AccountCreationActivity.this, "Account created!", Toast.LENGTH_SHORT).show();
            finish(); // Go back to MainActivity after account creation
        });
    }
}
