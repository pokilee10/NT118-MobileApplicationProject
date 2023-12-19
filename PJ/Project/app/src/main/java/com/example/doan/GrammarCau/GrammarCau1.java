package com.example.doan.GrammarCau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder1.GrammarCau1_1;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_10;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_11;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_12;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_3;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_4;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_5;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_6;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_7;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_8;
import com.example.doan.GrammarCau.Folder1.GrammarCau1_9;
import com.example.doan.GrammarCau.Folder1.grammar_cau1_2;
import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.R;

public class GrammarCau1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau1);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt2 = (ImageButton) findViewById(R.id.ibt2);
        ImageButton imgbt3 = (ImageButton) findViewById(R.id.ibt3);
        ImageButton imgbt4 = (ImageButton) findViewById(R.id.ibt4);
        ImageButton imgbt5 = (ImageButton) findViewById(R.id.ibt5);
        ImageButton imgbt6 = (ImageButton) findViewById(R.id.ibt6);
        ImageButton imgbt7 = (ImageButton) findViewById(R.id.ibt7);
        ImageButton imgbt8 = (ImageButton) findViewById(R.id.ibt8);
        ImageButton imgbt9 = (ImageButton) findViewById(R.id.ibt9);
        ImageButton imgbt10 = (ImageButton) findViewById(R.id.ibt10);
        ImageButton imgbt11 = (ImageButton) findViewById(R.id.ibt11);
        ImageButton imgbt12 = (ImageButton) findViewById(R.id.ibt12);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, grammar_cau1_2.class);
                startActivity(intent);
            }
        });

        imgbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_3.class);
                startActivity(intent);
            }
        });

        imgbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_4.class);
                startActivity(intent);
            }
        });

        imgbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_5.class);
                startActivity(intent);
            }
        });

        imgbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_6.class);
                startActivity(intent);
            }
        });

        imgbt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_7.class);
                startActivity(intent);
            }
        });

        imgbt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_8.class);
                startActivity(intent);
            }
        });

        imgbt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_9.class);
                startActivity(intent);
            }
        });

        imgbt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_10.class);
                startActivity(intent);
            }
        });

        imgbt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_11.class);
                startActivity(intent);
            }
        });

        imgbt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau1.this, GrammarCau1_12.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarCau.class);
        startActivity(intent);
    }
}