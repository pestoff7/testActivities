package com.example.testactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class third_question extends AppCompatActivity {

    Intent thirdQuest, result;
    RadioButton thirdRadioBut1;
    RadioButton thirdRadioBut2;
    RadioButton thirdRadioBut3;
    Button forwardButResult;
    int numberOfRightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);
        result = new Intent(third_question.this, result.class);
    }

    public void onClickResult(View v) {
        thirdRadioBut1 = findViewById(R.id.thirdRadioBut1);
        thirdRadioBut2 = findViewById(R.id.thirdRadioBut2);
        thirdRadioBut3 = findViewById(R.id.thirdRadioBut3);
        thirdQuest = getIntent();
        numberOfRightAnswers = thirdQuest.getIntExtra("number", 0);

        if (v.getId() == thirdRadioBut1.getId()) {
            result.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == thirdRadioBut2.getId()){
            result.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == thirdRadioBut3.getId()){
            numberOfRightAnswers += 1;
            result.putExtra("number", numberOfRightAnswers);
        }
    }

    public void forwardClickResult(View v) {
        forwardButResult = findViewById(R.id.thirdForwardButton);
        if (v.getId() == forwardButResult.getId()){
            startActivity(result);
        }
    }

}