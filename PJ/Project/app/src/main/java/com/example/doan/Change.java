package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Change extends AppCompatActivity {

    private TextInputLayout email, username, phonenumber, address;
    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    private DocumentReference ref;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        mAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        if(firebaseUser == null)
        {
            Toast.makeText(Change.this, "Something went wrong !!!", Toast.LENGTH_LONG).show();
        }
        else
        {
            
        }

    }
}