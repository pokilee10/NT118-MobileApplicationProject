package com.example.doan.Test;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;
import com.example.doan.TestClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class TestGrammar extends AppCompatActivity {

    ImageButton imgbtn_back;
    TextView tvQuesTime;
    CountDownTimer count;
    ProgressBar progressBarQuesTime;

    String Ans;
    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testgrammar);

        TextView tvQues = (TextView) findViewById(R.id.textViewQues);
        Button btnA = (Button) findViewById(R.id.btnAns1);
        Button btnB = (Button) findViewById(R.id.btnAns2);
        Button btnC = (Button) findViewById(R.id.btnAns3);
        Button btnD = (Button) findViewById(R.id.btnAns4);
        Button btnNext = (Button) findViewById(R.id.btnNextQues);
        Button btnBack = (Button) findViewById(R.id.btnBackQues);

        imgbtn_back = findViewById(R.id.imgbtn_back);
        tvQuesTime = findViewById(R.id.textViewQuesTime);
        progressBarQuesTime = findViewById(R.id.progressBarQuesTime);
        startTime();
        count.start();
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        LoadQues();
        ClickAns();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index += 1;
                RefreshButton();
                LoadQues();
                //ClickAns();
            }
        });
    }

    private void startTime() {
        count = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format(Locale.getDefault(), "%02d", seconds);
                tvQuesTime.setText(timeFormatted + "s");
                int current = progressBarQuesTime.getProgress();
                progressBarQuesTime.setProgress(current - 10);
            }

            @Override
            public void onFinish() {
                tvQuesTime.setText("0s");
                Toast.makeText(TestGrammar.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void Back() {
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }

    public void CheckAns() {
        Button btnA = (Button) findViewById(R.id.btnAns1);
        Button btnB = (Button) findViewById(R.id.btnAns2);
        Button btnC = (Button) findViewById(R.id.btnAns3);
        Button btnD = (Button) findViewById(R.id.btnAns4);
        if (btnA.getText().toString().equals(Ans)) btnA.setTextColor(0xFF00FF00);
        if (btnB.getText().toString().equals(Ans)) btnB.setTextColor(0xFF00FF00);
        if (btnC.getText().toString().equals(Ans)) btnC.setTextColor(0xFF00FF00);
        if (btnD.getText().toString().equals(Ans)) btnD.setTextColor(0xFF00FF00);
    }

    public void LoadQues() {
        TextView tvQues = (TextView) findViewById(R.id.textViewQues);
        Button btnA = (Button) findViewById(R.id.btnAns1);
        Button btnB = (Button) findViewById(R.id.btnAns2);
        Button btnC = (Button) findViewById(R.id.btnAns3);
        Button btnD = (Button) findViewById(R.id.btnAns4);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String indexString = Integer.toString(index);
        DatabaseReference myRef = database.getReference("testgrammar").child(indexString);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TestClass test = snapshot.getValue(TestClass.class);
                if (test != null) {
                    tvQues.setText(test.ques);
                    btnA.setText(test.ans1);
                    btnB.setText(test.ans2);
                    btnC.setText(test.ans3);
                    btnD.setText(test.ans4);
                    Ans = test.result.toString();
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

    public void ClickAns() {
        Button btnA = (Button) findViewById(R.id.btnAns1);
        Button btnB = (Button) findViewById(R.id.btnAns2);
        Button btnC = (Button) findViewById(R.id.btnAns3);
        Button btnD = (Button) findViewById(R.id.btnAns4);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnA.getText().toString() == Ans)
                {
                    btnA.setTextColor(0xFF00FF00);
                }
                else
                {
                    btnA.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = btnB.getText().toString();
                if (b.equals(Ans))
                {
                    btnB.setTextColor(0xFF00FF00);
                }
                else
                {
                    btnB.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnC.getText().toString() == Ans)
                {
                    btnC.setTextColor(0xFF00FF00);
                }
                else
                {
                    btnC.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnD.getText().toString() == Ans)
                {
                    btnD.setTextColor(0xFF00FF00);
                }
                else
                {
                    btnD.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });
    }

    public void RefreshButton() {
        Button btnA = (Button) findViewById(R.id.btnAns1);
        Button btnB = (Button) findViewById(R.id.btnAns2);
        Button btnC = (Button) findViewById(R.id.btnAns3);
        Button btnD = (Button) findViewById(R.id.btnAns4);


        btnA.setTextColor(0xFF000000);
        btnB.setTextColor(0xFF000000);
        btnC.setTextColor(0xFF000000);
        btnD.setTextColor(0xFF000000);
    }

}