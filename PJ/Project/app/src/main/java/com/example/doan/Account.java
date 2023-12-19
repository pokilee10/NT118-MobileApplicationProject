package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Account extends AppCompatActivity {

    private Button changeInfo;
    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    private DocumentReference ref;
    private TextView tvusername, tvemail, tvphonenumber, tvaddress, tvrank;
    private String username, email, phonenumber, address, rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageButton back = (ImageButton) findViewById(R.id.imgbtn_back);
        changeInfo = findViewById(R.id.btnChangeInfo);
        tvusername = findViewById(R.id.tvName);
        tvemail = findViewById(R.id.tvEmail);
        tvphonenumber = findViewById(R.id.tvPhonenumber);
        tvrank = findViewById(R.id.tvRank);

        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Change();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if(firebaseUser == null)
        {
            Toast.makeText(Account.this, "Something went wrong !!!", Toast.LENGTH_LONG).show();
        }
        else
        {
            showUserInfo(firebaseUser);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }

    private void showUserInfo(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetail readWriteUserDetail = snapshot.getValue(ReadWriteUserDetail.class);
                if( readWriteUserDetail != null)
                {
                    username = firebaseUser.getDisplayName();
                    email = firebaseUser.getEmail();
                    //phonenumber = readWriteUserDetail.phonenumber;
                    //address = readWriteUserDetail.address;
                    //rank = readWriteUserDetail.rank;

                    tvusername.setText(username);
                    tvemail.setText(email);
                    //tvphonenumber.setText(phonenumber);
                    //tvaddress.setText(address);
                    //tvrank.setText(rank);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Account.this, "Something went wrong !!!", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void Change(){
        Intent intent = new Intent(this, Change.class);
        startActivity(intent);
    }
}