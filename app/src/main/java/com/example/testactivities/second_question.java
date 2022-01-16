package com.example.testactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class second_question extends AppCompatActivity {

    Intent secondQuest, thirdQuest;
    RadioButton secondRadioBut1;
    RadioButton secondRadioBut2;
    RadioButton secondRadioBut3;
    Button forwardButThird, secondButBack;
    int numberOfRightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        thirdQuest = new Intent(second_question.this, third_question.class);
    }

    public void onClickThird(View v) {
        secondRadioBut1 = findViewById(R.id.secondRadioBut1);
        secondRadioBut2 = findViewById(R.id.secondRadioBut2);
        secondRadioBut3 = findViewById(R.id.secondRadioBut3);
        secondQuest = getIntent();
        numberOfRightAnswers = secondQuest.getIntExtra("number", 0);

        if (v.getId() == secondRadioBut1.getId()) {
            secondRadioBut1.setEnabled(false);
            secondRadioBut2.setEnabled(false);
            secondRadioBut3.setEnabled(false);
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == secondRadioBut2.getId()){
            numberOfRightAnswers += 1;
            secondRadioBut1.setEnabled(false);
            secondRadioBut2.setEnabled(false);
            secondRadioBut3.setEnabled(false);
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == secondRadioBut3.getId()){
            secondRadioBut1.setEnabled(false);
            secondRadioBut2.setEnabled(false);
            secondRadioBut3.setEnabled(false);
            thirdQuest.putExtra("number", numberOfRightAnswers);
        }
    }

    public void forwardClickThird(View v) {
        forwardButThird = findViewById(R.id.secondForwardButton);
        if (v.getId() == forwardButThird.getId()){
            startActivityForResult(thirdQuest, 1);
        }
    }

    public void secondBackButton(View v) {
        secondButBack = findViewById(R.id.secondBackButton);
        if (v.getId() == secondButBack.getId()){
            Intent backFirstIntent = new Intent();
            backFirstIntent.putExtra("number", numberOfRightAnswers);
            setResult(RESULT_OK, backFirstIntent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null){
            return;
        }
        this.getIntent().getIntExtra("number", 0);
    }
}