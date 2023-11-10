package com.example.doan.MainMenuFolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.GrammarWord.GrammarTu1;
import com.example.doan.MainMenu;
import com.example.doan.R;
import com.example.doan.Vocabulary.Voc1;

public class Vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton imgbt_1 = (ImageButton) findViewById(R.id.ibt1);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        imgbt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vocabulary.this, Voc1.class);
                startActivity(intent);
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}