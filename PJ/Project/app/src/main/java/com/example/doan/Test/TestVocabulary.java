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
import com.example.doan.ViewResult.ListResultItems;
import com.example.doan.ViewResult.ViewResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.Locale;

public class TestVocabulary extends AppCompatActivity {

    ImageButton imgbtn_back;
    TextView tvQuesTime;
    CountDownTimer count;
    ProgressBar progressBarQuesTime;
    String Ans;
    private int numCorrect = 0;
    private int numWrong = 0;
    private int index = 1;
    private int numques = 1;
    private ListResultItems listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocabulary);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);

        Button btnNext = (Button) findViewById(R.id.btnNextQues);
        TextView tvQuesCount = (TextView) findViewById(R.id.textViewQuesCount);
        ProgressBar progressBarQues = (ProgressBar) findViewById(R.id.progressQues);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);


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
                count.cancel();
                ResetClock();
                count.start();
                index += 1;
                numques += 1;
                progressBarQues.setProgress(progressBarQues.getProgress()+10);
                if (numques == 10) btnNext.setEnabled(false);
                String numQuesString = Integer.toString(numques);
                tvQuesCount.setText(numQuesString + "/10");
                RefreshButton();
                LoadQues();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();
                intentResult.setClass(TestVocabulary.this, TestResult.class);
                String indexStringCorrect = Integer.toString(numCorrect);
                String indexStringWrong = Integer.toString(numWrong);
                intentResult.putExtra("numCorrect", indexStringCorrect);
                intentResult.putExtra("numWrong", indexStringWrong);
                startActivity(intentResult);
                count.cancel();
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
                Button btnNext = (Button) findViewById(R.id.btnNextQues);
                if (numques < 10) btnNext.performClick();
                Toast.makeText(TestVocabulary.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void Back() {
        count.cancel();
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

        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String indexString = Integer.toString(index);
        DatabaseReference myRef = database.getReference("testvocab").child(indexString);

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
                    listItem = new ListResultItems(test.ques, test.ans1, test.ans2, test.ans3, test.ans4, test.result, 0);
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
                AddQuestion(1);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                String a = btnA.getText().toString();
                if (a.equals(Ans))
                {
                    numCorrect++;
                    btnA.setTextColor(0xFF00FF00);
                }
                else
                {
                    numWrong++;
                    btnA.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuestion(2);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                String b = btnB.getText().toString();
                if (b.equals(Ans))
                {
                    numCorrect++;
                    btnB.setTextColor(0xFF00FF00);
                }
                else
                {
                    numWrong++;
                    btnB.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuestion(3);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                if (btnC.getText().toString().equals(Ans))
                {
                    numCorrect++;
                    btnC.setTextColor(0xFF00FF00);
                }
                else
                {
                    numWrong++;
                    btnC.setTextColor(0xFFFF0000);
                    CheckAns();
                }
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuestion(4);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                if (btnD.getText().toString().equals(Ans))
                {
                    numCorrect++;
                    btnD.setTextColor(0xFF00FF00);
                }
                else
                {
                    numWrong++;
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

    public void ResetClock() {
        ProgressBar progressBarQuesTime = (ProgressBar) findViewById(R.id.progressBarQuesTime);
        TextView textViewQuesTime = (TextView) findViewById(R.id.textViewQuesTime);
        textViewQuesTime.setText("30s");
        progressBarQuesTime.setProgress(300);
    }

    public void AddQuestion(int pos) {
        listItem.setPos(pos);
        ViewResult.listItems.add(listItem);
        listItem = null;
    }
}