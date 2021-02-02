package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int NUMBER_ROUNDS = 2;
    private int numberCorrect = 0;
    private String myString = "";
    private Feedback feedback;
    TextView messageText;
    Button startButton;
    Button resetButton;
    Button redButton;
    Button blueButton;
    Button greenButton;
    Button pinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageText = findViewById(R.id.message);
        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        greenButton = findViewById(R.id.greenButton);
        pinkButton = findViewById(R.id.pinkButton);
        resetButton.setEnabled(false);
    }
    private void evaluateUser() {
        if (numberCorrect == NUMBER_ROUNDS) {
            myString = getString(R.string.Perfect_Score);

        } else
            myString = getString(R.string.Pay_Attention);
        feedback.setText(myString);
    }

}