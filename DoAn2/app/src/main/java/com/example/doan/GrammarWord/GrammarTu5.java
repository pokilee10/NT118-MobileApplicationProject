package com.example.doan.GrammarWord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarWord.Folder4.GrammarTu4_1;
import com.example.doan.GrammarWord.Folder4.GrammarTu4_2;
import com.example.doan.GrammarWord.Folder4.GrammarTu4_3;
import com.example.doan.GrammarWord.Folder4.GrammarTu4_4;
import com.example.doan.GrammarWord.Folder4.GrammarTu4_5;
import com.example.doan.GrammarWord.Folder5.GrammarTu5_1;
import com.example.doan.GrammarWord.Folder5.GrammarTu5_2;
import com.example.doan.GrammarWord.Folder5.GrammarTu5_3;
import com.example.doan.GrammarWord.Folder5.GrammarTu5_4;
import com.example.doan.MainMenuFolder.GrammarTu;
import com.example.doan.R;

public class GrammarTu5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_tu5);
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
                Intent intent = new Intent(GrammarTu5.this, GrammarTu5_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu5.this, GrammarTu5_2.class);
                startActivity(intent);
            }
        });

        imgbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu5.this, GrammarTu5_3.class);
                startActivity(intent);
            }
        });

        imgbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarTu5.this, GrammarTu5_4.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarTu.class);
        startActivity(intent);
    }
}