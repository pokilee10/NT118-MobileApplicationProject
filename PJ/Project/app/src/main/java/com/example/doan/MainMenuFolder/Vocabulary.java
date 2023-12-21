package com.example.doan.MainMenuFolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarWord.GrammarTu1;
import com.example.doan.MainMenu;
import com.example.doan.R;
import com.example.doan.Vocabulary.Voc1;
import com.example.doan.Vocabulary.Voc10;
import com.example.doan.Vocabulary.Voc2;
import com.example.doan.Vocabulary.Voc3;
import com.example.doan.Vocabulary.Voc4;
import com.example.doan.Vocabulary.Voc5;
import com.example.doan.Vocabulary.Voc6;
import com.example.doan.Vocabulary.Voc7;
import com.example.doan.Vocabulary.Voc8;
import com.example.doan.Vocabulary.Voc9;

public class Vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt_1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt_2 = (ImageButton) findViewById(R.id.ibt2);
        ImageButton imgbt_3 = (ImageButton) findViewById(R.id.ibt3);
        ImageButton imgbt_4 = (ImageButton) findViewById(R.id.ibt4);
        ImageButton imgbt_5 = (ImageButton) findViewById(R.id.ibt5);
        ImageButton imgbt_6 = (ImageButton) findViewById(R.id.ibt6);
        ImageButton imgbt_7 = (ImageButton) findViewById(R.id.ibt7);
        ImageButton imgbt_8 = (ImageButton) findViewById(R.id.ibt8);
        ImageButton imgbt_9 = (ImageButton) findViewById(R.id.ibt9);
        ImageButton imgbt_10 = (ImageButton) findViewById(R.id.ibt10);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc1.class);
                startActivity(intent);
            }
        });

        imgbt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc2.class);
                startActivity(intent);
            }
        });

        imgbt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc3.class);
                startActivity(intent);
            }
        });

        imgbt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc4.class);
                startActivity(intent);
            }
        });

        imgbt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc5.class);
                startActivity(intent);
            }
        });

        imgbt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc6.class);
                startActivity(intent);
            }
        });

        imgbt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc7.class);
                startActivity(intent);
            }
        });

        imgbt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc8.class);
                startActivity(intent);
            }
        });

        imgbt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc9.class);
                startActivity(intent);
            }
        });

        imgbt_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc10.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}