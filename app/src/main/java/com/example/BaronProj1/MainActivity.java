package com.example.BaronProj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int NUMBER_ROUNDS = 2;
    private String rightString = "";
    private String wrongString = "";
    private int numberCorrect = 0;
    private int numberWrong = 0;
    private String myString = "";
    private String color = "";
    TextView messageText;
    Button startButton;
    Button resetButton;
    Button redButton;
    Button blueButton;
    Button greenButton;
    Button pinkButton;
    TextView numbRight;
    TextView numbWrong;
    Random rand = new Random();

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
        numbRight = findViewById(R.id.right);
        numbWrong = findViewById(R.id.wrong);
        resetButton.setEnabled(false);
        disableColorButtons();
        numbRight.setAlpha(0);
        numbWrong.setAlpha(0);
        rightString = getString(R.string.NumbRight);
        wrongString = getString(R.string.NumbWrong);
    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetButton.setEnabled(true);
            startButton.setEnabled(false);
            enableColorButtons();
            numbRight.setAlpha(1);
            numbWrong.setAlpha(1);
            numbRight.setText(rightString + numberCorrect);
            numbWrong.setText(wrongString + numberWrong);
            int n = rand.nextInt(4);
            setRandomColor(n);

        }
    });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton.setEnabled(false);
                startButton.setEnabled(true);
                disableColorButtons();
                numbRight.setAlpha(0);
                numbWrong.setAlpha(0);
                numberCorrect = 0;
                numberWrong = 0;
                myString = "";
                color = "";
                messageText.setText(getString(R.string.press_start_to_begin));
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.equals("red")){
                    numberCorrect++;
                    numbRight.setText(rightString + numberCorrect);
                }else{
                    numberWrong++;
                    numbWrong.setText(wrongString + numberWrong);
                }
                if(numberWrong + numberCorrect >= NUMBER_ROUNDS){
                    disableColorButtons();
                    evaluateUser();
                }else{
                    int n = rand.nextInt(4);
                    setRandomColor(n);
                }
            }
        });
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.equals("blue")){
                    numberCorrect++;
                    numbRight.setText(rightString + numberCorrect);
                }else{
                    numberWrong++;
                    numbWrong.setText(wrongString +numberWrong);
                }
                if(numberWrong + numberCorrect >= NUMBER_ROUNDS){
                    disableColorButtons();
                    evaluateUser();
                }else{
                    int n = rand.nextInt(4);
                    setRandomColor(n);
                }
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.equals("green")){
                    numberCorrect++;
                    numbRight.setText(rightString+ numberCorrect);
                }else{
                    numberWrong++;
                    numbWrong.setText(wrongString + numberWrong);
                }
                if(numberWrong + numberCorrect >= NUMBER_ROUNDS){
                    disableColorButtons();
                    evaluateUser();
                }else{
                    int n = rand.nextInt(4);
                    setRandomColor(n);
                }
            }
        });
        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(color.equals("pink")){
                    numberCorrect++;
                    numbRight.setText(rightString +numberCorrect);
                }else{
                    numberWrong++;
                    numbWrong.setText(wrongString + numberWrong);
                }
                if(numberWrong + numberCorrect >= NUMBER_ROUNDS){
                    disableColorButtons();
                    evaluateUser();
                }else{
                    int n = rand.nextInt(4);
                    setRandomColor(n);
                }
            }
        });
    }
    private void evaluateUser() {
        if (numberCorrect == NUMBER_ROUNDS) {
            myString = getString(R.string.Perfect_Score);

        } else
            myString = getString(R.string.Pay_Attention);
        messageText.setText(myString);
    }
    public void setRandomColor(int n){
        if(n == 0){
            color = "red";
            messageText.setText(getString(R.string.Press_Red));
        }else if(n == 1){
            color = "blue";
            messageText.setText(getText(R.string.Press_Blue));
        }else if(n == 2){
            color = "green";
            messageText.setText(getText(R.string.Press_Green));
        }else{
            color = "pink";
            messageText.setText(getText(R.string.Press_Pink));
        }
    }
    public void disableColorButtons(){
        redButton.setEnabled(false);
        blueButton.setEnabled(false);
        greenButton.setEnabled(false);
        pinkButton.setEnabled(false);
    }
    public void enableColorButtons(){
        redButton.setEnabled(true);
        blueButton.setEnabled(true);
        greenButton.setEnabled(true);
        pinkButton.setEnabled(true);
    }
}