package com.example.doan.GrammarWord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder2.GrammarCau2_1;
import com.example.doan.GrammarCau.Folder2.GrammarCau2_2;
import com.example.doan.GrammarCau.GrammarCau2;
import com.example.doan.GrammarWord.Folder2.GrammarTu2_1;
import com.example.doan.GrammarWord.Folder2.GrammarTu2_2;
import com.example.doan.GrammarWord.Folder2.GrammarTu2_3;
import com.example.doan.GrammarWord.Folder2.GrammarTu2_4;
import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.MainMenuFolder.GrammarTu;
import com.example.doan.R;

public class GrammarTu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_tu2);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt2 = (ImageButton) findViewById(R.id.ibt2);
        ImageButton imgbt3 = (ImageButton) findViewById(R.id.ibt3);
        ImageButton imgbt4 = (ImageButton) findViewById(R.id.ibt4);

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu2.this, GrammarTu2_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu2.this, GrammarTu2_2.class);
                startActivity(intent);
            }
        });

        imgbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu2.this, GrammarTu2_3.class);
                startActivity(intent);
            }
        });

        imgbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu2.this, GrammarTu2_4.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarTu.class);
        startActivity(intent);
    }
}