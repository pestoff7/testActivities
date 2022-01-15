package com.example.testactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Intent secondQuest;
    RadioButton radioBut1;
    RadioButton radioBut2;
    RadioButton radioBut3;
    Button forwardBut;
    int numberOfRightAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        secondQuest = new Intent(MainActivity.this, second_question.class);
        radioBut1 = findViewById(R.id.radioBut1);
        radioBut2 = findViewById(R.id.radioBut2);
        radioBut3 = findViewById(R.id.radioBut3);


        if (v.getId() == radioBut1.getId()) {
            numberOfRightAnswers += 1;
            secondQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == radioBut2.getId()){
            secondQuest.putExtra("number", numberOfRightAnswers);
        }
        else if (v.getId() == radioBut3.getId()){
            secondQuest.putExtra("number", numberOfRightAnswers);
        }
    }

    public void forwardClick(View v) {
        forwardBut = findViewById(R.id.forwardButton);
        secondQuest = new Intent(MainActivity.this, second_question.class);
        if (v.getId() == forwardBut.getId()){
            startActivity(secondQuest);
        }
    }
}