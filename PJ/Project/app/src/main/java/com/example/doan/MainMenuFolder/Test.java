package com.example.doan.MainMenuFolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.MainMenu;
import com.example.doan.R;
import com.example.doan.Test.TestGrammar;
import com.example.doan.Test.TestGrammarStart;
import com.example.doan.Test.TestVocabStart;
import com.example.doan.Test.TestVocabulary;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbtn_grammar = (ImageButton) findViewById(R.id.imbt_check_grammar);
        ImageButton imgbtn_vocabulary = (ImageButton) findViewById(R.id.imbt_check_vocabulary);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbtn_grammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test.this, TestGrammarStart.class);
                startActivity(intent);
            }
        });
        imgbtn_vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test.this, TestVocabStart.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}