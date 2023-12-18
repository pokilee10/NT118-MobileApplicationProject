package com.example.doan.MainMenuFolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder5.GrammarCau5_3;
import com.example.doan.GrammarCau.GrammarCau1;
import com.example.doan.GrammarCau.GrammarCau10;
import com.example.doan.GrammarCau.GrammarCau2;
import com.example.doan.GrammarCau.GrammarCau3;
import com.example.doan.GrammarCau.GrammarCau4;
import com.example.doan.GrammarCau.GrammarCau5;
import com.example.doan.GrammarCau.GrammarCau6;
import com.example.doan.GrammarCau.GrammarCau7;
import com.example.doan.GrammarCau.GrammarCau8;
import com.example.doan.GrammarCau.GrammarCau9;
import com.example.doan.MainActivity;
import com.example.doan.MainMenu;
import com.example.doan.R;

public class GrammarCau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau);
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
        ImageButton imgbt_11 = (ImageButton) findViewById(R.id.ibt11);
        ImageButton imgbt_12 = (ImageButton) findViewById(R.id.ibt12);
        ImageButton imgbt_13 = (ImageButton) findViewById(R.id.ibt13);
        ImageButton imgbt_14 = (ImageButton) findViewById(R.id.ibt14);
        ImageButton imgbt_15 = (ImageButton) findViewById(R.id.ibt15);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau1.class);
                startActivity(intent);
            }
        });

        imgbt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau2.class);
                startActivity(intent);
            }
        });

        imgbt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau3.class);
                startActivity(intent);
            }
        });

        imgbt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau4.class);
                startActivity(intent);
            }
        });

        imgbt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau5.class);
                startActivity(intent);
            }
        });

        imgbt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau6.class);
                startActivity(intent);
            }
        });

        imgbt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau7.class);
                startActivity(intent);
            }
        });

        imgbt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau8.class);
                startActivity(intent);
            }
        });

        imgbt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau9.class);
                startActivity(intent);
            }
        });

        imgbt_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau.this, GrammarCau10.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}