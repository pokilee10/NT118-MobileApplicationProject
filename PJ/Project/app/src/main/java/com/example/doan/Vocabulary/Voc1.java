package com.example.doan.Vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.MainMenuFolder.Vocabulary;
import com.example.doan.R;

public class Voc1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voc1);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, Vocabulary.class);
        startActivity(intent);
    }
}