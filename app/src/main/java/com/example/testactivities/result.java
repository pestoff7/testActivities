package com.example.testactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    Intent thirdQuest;
    TextView resultText;
    int numberOfRightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText = findViewById(R.id.resultsText);
        thirdQuest = getIntent();
        numberOfRightAnswers = thirdQuest.getIntExtra("number", 0);
        resultText.setText("Количество правильных ответов: " + numberOfRightAnswers);
    }
}