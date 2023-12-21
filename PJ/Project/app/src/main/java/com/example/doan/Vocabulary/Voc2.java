package com.example.doan.Vocabulary;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.doan.MainMenuFolder.Vocabulary;
import com.example.doan.R;
import com.example.doan.Vocab;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Voc2 extends AppCompatActivity {

    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voc2);
        Button btnNext = (Button) findViewById(R.id.btnNextQues);
        Button btnBack = (Button) findViewById(R.id.btnBackQues);
        TextView textWord = (TextView) findViewById(R.id.textViewVoc);
        TextView textMean = (TextView) findViewById(R.id.textViewNghia);
        TextView textNumTu = (TextView) findViewById(R.id.textViewNumTu);
        TextView textSpell = (TextView) findViewById(R.id.textViewPhienAm);
        TextView textExamp1 = (TextView) findViewById(R.id.textViewVDE);
        TextView textExamp2 = (TextView) findViewById(R.id.textViewVDV);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String indexString = Integer.toString(index);
        DatabaseReference myRef = database.getReference("vocab").child("marketing").child(indexString);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Vocab vocab = snapshot.getValue(Vocab.class);
                if (vocab != null) {
                    textWord.setText(vocab.word);
                    textMean.setText(vocab.means);
                    textSpell.setText(vocab.spelling);
                    textExamp1.setText(vocab.examp1);
                    textExamp2.setText(vocab.examp2);
                } else {
                    Log.w(TAG, "No data found at contracts");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index + 1;
                if (index == 1)
                {
                    btnBack.setEnabled(false);
                } else
                {
                    btnBack.setEnabled(true);
                }
                if (index == 12)
                {
                    btnNext.setEnabled(false);
                } else
                {
                    btnNext.setEnabled(true);
                }
                String indexString = Integer.toString(index);
                textNumTu.setText(indexString+"/12");
                DatabaseReference myRef = database.getReference("vocab").child("marketing").child(indexString);

                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Vocab vocab = snapshot.getValue(Vocab.class);
                        if (vocab != null) {
                            textWord.setText(vocab.word);
                            textMean.setText(vocab.means);
                            textSpell.setText(vocab.spelling);
                            textExamp1.setText(vocab.examp1);
                            textExamp2.setText(vocab.examp2);
                        } else {
                            Log.w(TAG, "No data found at contracts");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index - 1;
                if (index == 1)
                {
                    btnBack.setEnabled(false);
                } else
                {
                    btnBack.setEnabled(true);
                }
                if (index == 12)
                {
                    btnNext.setEnabled(false);
                } else
                {
                    btnNext.setEnabled(true);
                }
                String indexString = Integer.toString(index);
                textNumTu.setText(indexString+"/12");
                DatabaseReference myRef = database.getReference("vocab").child("marketing").child(indexString);

                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Vocab vocab = snapshot.getValue(Vocab.class);
                        if (vocab != null) {
                            textWord.setText(vocab.word);
                            textMean.setText(vocab.means);
                            textSpell.setText(vocab.spelling);
                            textExamp1.setText(vocab.examp1);
                            textExamp2.setText(vocab.examp2);
                        } else {
                            Log.w(TAG, "No data found at contracts");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, Vocabulary.class);
        startActivity(intent);
    }
}