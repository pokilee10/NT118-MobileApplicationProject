package com.example.doan.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;
import com.example.doan.ViewResult.ViewResult;

public class TestResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        TextView tvNumCorrect = (TextView) findViewById(R.id.tvNumCorrect);
        TextView tvNumWrong = (TextView) findViewById(R.id.tvNumWrong);
        TextView tvCorrect = (TextView) findViewById(R.id.textViewQuesTime);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarQuesTime);
        Button btnHome = (Button) findViewById(R.id.btnbacktohome);
        Button btnViewResult = findViewById(R.id.buttonViewResult);
        Intent intent = getIntent();
        String numCorrect = intent.getStringExtra("numCorrect");
        String numWrong = intent.getStringExtra("numWrong");
        if (numCorrect != null || numWrong != null) {

            TextView tvNumNotAns = (TextView) findViewById(R.id.tvNumNotAns);
            tvNumCorrect.setText(numCorrect);
            tvNumWrong.setText(numWrong);
            int numberCorrect = Integer.parseInt(numCorrect);
            int numberWrong = Integer.parseInt(numWrong);
            int index = numberCorrect * 10;
            progressBar.setProgress(index);
            tvCorrect.setText(index + "%");
            String indexStringNotAns = Integer.toString(10 - numberCorrect - numberWrong);
            tvNumNotAns.setText(indexStringNotAns);

        }
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(TestResult.this, Test.class);
                    startActivity(intent1);
                }
            });
            btnViewResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewResult = new Intent(TestResult.this, ViewResult.class);
                    startActivity(viewResult);
                }
            });

    }
}