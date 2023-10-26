package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSignUp = (TextView) findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });

        TextView tvForgot = (TextView) findViewById(R.id.textButtonForgot);
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Forget();
            }
        });

        Button btSignIn = (Button) findViewById(R.id.filledTonalButtonSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {MainMenu();}
        });

    }


    public void Signup(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void Forget(){
        Intent intent = new Intent(this, Forget.class);
        startActivity(intent);
    }
    public void MainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}