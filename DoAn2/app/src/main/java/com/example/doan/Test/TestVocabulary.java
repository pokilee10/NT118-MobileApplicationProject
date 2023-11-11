package com.example.doan.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;

import java.util.Locale;

public class TestVocabulary extends AppCompatActivity {

    TextView tvQuesTime;
    CountDownTimer count;
    ProgressBar progressBarQuesTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocabulary);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);

        tvQuesTime = findViewById(R.id.textViewQuesTime);
        progressBarQuesTime = findViewById(R.id.progressBarQuesTime);
        startTime();
        count.start();
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }

    private void startTime() {
        count = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format(Locale.getDefault(), "%02d", seconds);
                tvQuesTime.setText(timeFormatted + "s");
                int current = progressBarQuesTime.getProgress();
                progressBarQuesTime.setProgress(current - 10);
            }

            @Override
            public void onFinish() {
                tvQuesTime.setText("0s");
                Toast.makeText(TestVocabulary.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void Back(){
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}