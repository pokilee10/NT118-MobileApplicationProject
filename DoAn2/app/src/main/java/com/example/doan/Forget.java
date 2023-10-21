package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Forget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Forget Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}