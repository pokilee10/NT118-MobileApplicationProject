package com.example.doan.GrammarCau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.Folder5.GrammarCau5_1;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_2;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_3;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_4;
import com.example.doan.GrammarCau.Folder5.GrammarCau5_5;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_1;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_2;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_3;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_4;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_5;
import com.example.doan.GrammarCau.Folder6.GrammarCau6_6;
import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.R;

public class GrammarCau6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau6);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt1 = (ImageButton) findViewById(R.id.ibt1);
        ImageButton imgbt2 = (ImageButton) findViewById(R.id.ibt2);
        ImageButton imgbt3 = (ImageButton) findViewById(R.id.ibt3);
        ImageButton imgbt4 = (ImageButton) findViewById(R.id.ibt4);
        ImageButton imgbt5 = (ImageButton) findViewById(R.id.ibt5);
        ImageButton imgbt6 = (ImageButton) findViewById(R.id.ibt6);

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_1.class);
                startActivity(intent);
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_2.class);
                startActivity(intent);
            }
        });

        imgbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_3.class);
                startActivity(intent);
            }
        });

        imgbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_4.class);
                startActivity(intent);
            }
        });

        imgbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_5.class);
                startActivity(intent);
            }
        });

        imgbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrammarCau6.this, GrammarCau6_6.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, GrammarCau.class);
        startActivity(intent);
    }
}