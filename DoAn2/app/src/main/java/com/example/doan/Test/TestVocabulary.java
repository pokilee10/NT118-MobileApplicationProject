package com.example.doan.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;

public class TestVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocabulary);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}