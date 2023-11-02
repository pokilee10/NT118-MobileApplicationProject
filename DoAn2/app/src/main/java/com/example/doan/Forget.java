package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Forget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        TextInputLayout email = findViewById(R.id.outlinedTextFieldEmail);

        Button changepass = (Button) findViewById(R.id.filledTonalButtonChangePass);

        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = String.valueOf(email.getEditText().getText());
                FirebaseAuth.getInstance().sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Forget.this, "Check your mail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }

    public void Back(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}