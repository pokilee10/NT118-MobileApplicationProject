package com.example.doan.ViewResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.doan.MainMenu;
import com.example.doan.MainMenuFolder.Test;
import com.example.doan.R;
import com.example.doan.Test.TestGrammar;
import com.example.doan.Test.TestResult;

import java.util.ArrayList;
import java.util.List;

public class ViewResult extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ImageButton btnBack;
    public static List<ListResultItems> listItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result_questions);

        btnBack = findViewById(R.id.imgbtn_back);
        recyclerView = findViewById(R.id.recycleviewResultQuestion);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ResultAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });


    }
    public void Back(){
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}