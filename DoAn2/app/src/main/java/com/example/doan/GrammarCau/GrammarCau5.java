package com.example.doan.GrammarCau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder3.GrammarCau3_1;
import com.example.doan.GrammarCau.Folder3.GrammarCau3_2;
import com.example.doan.GrammarCau.Folder3.GrammarCau3_3;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_1;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_2;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_3;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_4;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_5;
import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.R;

public class GrammarCau5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau5);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt2 = (ImageButton) findViewById(R.id.ibt2);
        ImageButton imgbt3 = (ImageButton) findViewById(R.id.ibt3);
        ImageButton imgbt4 = (ImageButton) findViewById(R.id.ibt4);
        ImageButton imgbt5 = (ImageButton) findViewById(R.id.ibt5);

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau5.this, GrammarCau5_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau5.this, GrammarCau5_2.class);
                startActivity(intent);
            }
        });

        imgbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau5.this, GrammarCau5_3.class);
                startActivity(intent);
            }
        });

        imgbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau5.this, GrammarCau5_4.class);
                startActivity(intent);
            }
        });

        imgbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau5.this, GrammarCau5_5.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarCau.class);
        startActivity(intent);
    }
}