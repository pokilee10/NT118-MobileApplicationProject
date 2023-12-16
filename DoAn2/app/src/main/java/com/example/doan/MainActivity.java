package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout email;
    private TextInputLayout password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        email = findViewById(R.id.outlinedTextFieldEmail);
        password = findViewById(R.id.outlinedTextFieldPassword);

        mAuth = FirebaseAuth.getInstance();



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
            public void onClick(View v) {
                String em = String.valueOf(email.getEditText().getText()).toString().trim();
                String pass = String.valueOf(password.getEditText().getText().toString().trim());
                if (em.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter your email !!!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (pass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter your password", Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(em, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                                    MainMenu();
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
            MainMenu();
            finish();
        }
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