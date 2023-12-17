package com.example.doan.GrammarCau.Folder2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarCau.GrammarCau1;
import com.example.doan.GrammarCau.GrammarCau2;
import com.example.doan.R;

public class GrammarCau2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_cau21);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }
    public void Back(){
        Intent intent = new Intent(this, GrammarCau2.class);
        startActivity(intent);
    }
}