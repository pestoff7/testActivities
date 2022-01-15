package com.example.testactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class second_question extends AppCompatActivity {

    Intent secondQuest, thirdQuest;
    RadioButton secondRadioBut1;
    RadioButton secondRadioBut2;
    RadioButton secondRadioBut3;
    Button forwardButThird;
    int numberOfRightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
    }

    public void onClickThird(View v) {

        thirdQuest = new Intent(second_question.this, third_question.class);
        secondRadioBut1 = findViewById(R.id.secondRadioBut1);
        secondRadioBut2 = findViewById(R.id.secondRadioBut2);
        secondRadioBut3 = findViewById(R.id.secondRadioBut3);
        secondQuest = getIntent();
        numberOfRightAnswers = secondQuest.getIntExtra("number", 0);

        if (v.getId() == secondRadioBut1.getId()) {
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == secondRadioBut2.getId()){
            numberOfRightAnswers += 1;
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == secondRadioBut3.getId()){
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
    }

    public void forwardClickThird(View v) {
        forwardButThird = findViewById(R.id.secondForwardButton);
        thirdQuest = new Intent(second_question.this, third_question.class);
        if (v.getId() == forwardButThird.getId()){
            startActivity(thirdQuest);
        }
    }

}