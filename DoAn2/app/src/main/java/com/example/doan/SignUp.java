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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private ImageButton imgbtn_back;
    private Button  SignUp;
    private TextInputLayout email;
    private TextInputLayout password;
    private TextInputLayout verifypass;
    private TextInputLayout username;
    private FirebaseFirestore fstore;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activy_main_signup);

         fstore= FirebaseFirestore.getInstance();

        imgbtn_back = findViewById(R.id.imgbtn_back);
        SignUp = findViewById(R.id.filledTonalButtonSignUp);
        email = findViewById(R.id.outlinedTextFieldEmail);
        password = findViewById(R.id.outlinedTextFieldPassword);
        verifypass = findViewById(R.id.outlinedTextFieldVerifyPassword);
        username = findViewById(R.id.outlinedTextFieldUserName);

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignUp();
            }
        });

    }

    private void Back(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private void onClickSignUp()
    {
        String em = String.valueOf(email.getEditText().getText()).toString().trim();
        String pass = String.valueOf(password.getEditText().getText().toString().trim());
        String verify = String.valueOf(verifypass.getEditText().getText().toString().trim());
        String usern = String.valueOf(username.getEditText().getText().toString().trim());


        if (usern.isEmpty())
        {
            Toast.makeText(SignUp.this, "Enter your username !!!", Toast.LENGTH_LONG).show();
            return;
        }

        if (pass.isEmpty())
        {
            Toast.makeText(SignUp.this, "Enter your password", Toast.LENGTH_LONG).show();
            return;
        }

        if (verify.isEmpty())
        {
            Toast.makeText(SignUp.this, "Enter verify password", Toast.LENGTH_LONG).show();
            return;
        }

        if (em.isEmpty())
        {
            Toast.makeText(SignUp.this, "Enter your email !!!", Toast.LENGTH_LONG).show();
            return;
        }
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            Map<String, String> user = new HashMap<>();
                            user.put("Username", usern);
                            user.put("Email", em);
                            user.put("Password", pass);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(SignUp.this, "Your account has been registered!! Let's login and try our servicec", Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            });
                        }
                    }
                });
    }
}