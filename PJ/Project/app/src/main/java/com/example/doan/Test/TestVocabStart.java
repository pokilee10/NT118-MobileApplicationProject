package com.example.doan.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;

public class TestVocabStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocab_start);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestVocabStart.this, TestVocabulary.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}