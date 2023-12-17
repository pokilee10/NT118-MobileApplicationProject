package com.example.doan.GrammarCau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder1.GrammarCau1_1;
import com.example.doan.GrammarCau.Folder1.grammar_cau1_2;
import com.example.doan.GrammarCau.Folder2.GrammarCau2_1;
import com.example.doan.GrammarCau.Folder2.GrammarCau2_2;
import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.R;

public class GrammarCau2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau2);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt2 = (ImageButton) findViewById(R.id.ibt2);

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau2.this, GrammarCau2_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau2.this, GrammarCau2_2.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarCau.class);
        startActivity(intent);
    }
}