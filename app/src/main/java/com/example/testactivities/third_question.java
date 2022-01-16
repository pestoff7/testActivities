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
    Button forwardButResult, thirdButBack;
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
            thirdRadioBut1.setEnabled(false);
            thirdRadioBut2.setEnabled(false);
            thirdRadioBut3.setEnabled(false);
            result.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == thirdRadioBut2.getId()){
            thirdRadioBut1.setEnabled(false);
            thirdRadioBut2.setEnabled(false);
            thirdRadioBut3.setEnabled(false);
            result.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == thirdRadioBut3.getId()){
            numberOfRightAnswers += 1;
            thirdRadioBut1.setEnabled(false);
            thirdRadioBut2.setEnabled(false);
            thirdRadioBut3.setEnabled(false);
            result.putExtra("number", numberOfRightAnswers);
        }
    }

    public void forwardClickResult(View v) {
        forwardButResult = findViewById(R.id.thirdForwardButton);
        if (v.getId() == forwardButResult.getId()){
            startActivity(result);
        }
    }

    public void thirdBackButton(View v) {
        thirdButBack = findViewById(R.id.thirdBackButton);
        if (v.getId() == thirdButBack.getId()){
            Intent backSecondIntent = new Intent();
            backSecondIntent.putExtra("number", numberOfRightAnswers);
            setResult(RESULT_OK, backSecondIntent);
            finish();
        }
    }

}