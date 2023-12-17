package com.example.doan.MainMenuFolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.GrammarCau1;
import com.example.doan.GrammarCau.GrammarCau2;
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
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}