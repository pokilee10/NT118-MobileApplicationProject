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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout email;
    private TextInputLayout password;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        email = findViewById(R.id.outlinedTextFieldEmail);
        password = findViewById(R.id.outlinedTextFieldPassword);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();


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
                /*DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                Query checkUserDatabase = reference.orderByChild("username").equalTo(em);

                checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            email.setError(null);
                            String passfromDB = snapshot.child(em).child("password").getValue(String.class);

                            if(!Objects.equals(passfromDB, "123456"))
                            {
                                email.setError(null);
                                Intent intent = new Intent(MainActivity.this, MainMenu.class);

                                startActivity(intent);
                            }
                            else
                            {
                                password.setError("Invalid Credentials");
                                password.requestFocus();
                            }
                        }
                        else
                        {
                            email.setError("User does not exist");
                            email.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/
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