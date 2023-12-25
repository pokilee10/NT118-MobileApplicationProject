package com.example.doan.MainMenuFolder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doan.LeaderboardAdapter;
import com.example.doan.MainActivity;
import com.example.doan.MainMenu;
import com.example.doan.R;
import com.example.doan.ReadWriteUserDetail;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoard extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ReadWriteUserDetail> list;
    DatabaseReference databaseReference;
    LeaderboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        recyclerView = findViewById(R.id.recylerviewLeaderboard);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //databaseReference = FirebaseDatabase.getInstance().getReference("users");
        list = new ArrayList<>();
        adapter = new LeaderboardAdapter(list);
        recyclerView.setAdapter(adapter);

        getListUserfromRealtimeDTB();

    }

    private void getListUserfromRealtimeDTB()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    ReadWriteUserDetail readWriteUserDetail = dataSnapshot.getValue(ReadWriteUserDetail.class);
                    list.add(readWriteUserDetail);
                }
                list.stream().count();
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Back(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}