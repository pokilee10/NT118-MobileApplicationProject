package com.example.doan.Test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doan.Account;
import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;
import com.example.doan.ReadWriteUserDetail;
import com.example.doan.ViewResult.ListResultItems;
import com.example.doan.ViewResult.ViewResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult extends AppCompatActivity {
    public static String numCor;
    public static String numWro;

    public static FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    public static String userid;
    public String score;
    public int scorenum = 0;
    Map<String, Object> updateData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        TextView tvNumCorrect = (TextView) findViewById(R.id.tvNumCorrect);
        TextView tvNumWrong = (TextView) findViewById(R.id.tvNumWrong);
        TextView tvCorrect = (TextView) findViewById(R.id.textViewQuesTime);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarQuesTime);
        Button btnHome = (Button) findViewById(R.id.btnbacktohome);
        Button btnViewResult = findViewById(R.id.buttonViewResult);
        Intent intent = getIntent();
        String numCorrect = intent.getStringExtra("numCorrect");
        String numWrong = intent.getStringExtra("numWrong");
        if (numCorrect != null || numWrong != null) {
            numCor = numCorrect;
            numWro = numWrong;
        }
        TextView tvNumNotAns = (TextView) findViewById(R.id.tvNumNotAns);
        tvNumCorrect.setText(numCor);
        tvNumWrong.setText(numWro);
        int numberCorrect = Integer.parseInt(numCor);
        int numberWrong = Integer.parseInt(numWro);
        int index = numberCorrect * 10;
        progressBar.setProgress(index);
        tvCorrect.setText(index + "%");
        String indexStringNotAns = Integer.toString(10 - numberCorrect - numberWrong);
        tvNumNotAns.setText(indexStringNotAns);



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                firebaseUser = mAuth.getCurrentUser();
                userid = firebaseUser.getUid();

                String userID = firebaseUser.getUid();

                FirebaseUser firebaseUser1 = FirebaseAuth.getInstance().getCurrentUser();

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


                DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(userID);

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ReadWriteUserDetail readWriteUserDetail = snapshot.getValue(ReadWriteUserDetail.class);
                        if(readWriteUserDetail != null)
                        {
                            score = readWriteUserDetail.score;
                            scorenum = Integer.parseInt(score);
                            scorenum = scorenum + numberCorrect;
                            score = Integer.toString(scorenum);
                            updateData.put("score", score);
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

                            databaseReference.child(userID).updateChildren(updateData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Cập nhật display name của user
                                        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(score)
                                                .build();

                                        firebaseUser.updateProfile(profileChangeRequest);
                                    } else {
                                        // Xử lý khi cập nhật không thành công
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Intent intent1 = new Intent(TestResult.this, Test.class);
                ViewResult.listItems.clear();
                startActivity(intent1);
            }
        });
        btnViewResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewResult = new Intent(TestResult.this, ViewResult.class);
                startActivity(viewResult);
            }
        });
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference =  firebaseDatabase.getReference("users");
//        databaseReference.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
}