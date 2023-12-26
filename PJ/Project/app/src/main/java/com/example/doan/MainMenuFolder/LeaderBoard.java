package com.example.doan.MainMenuFolder;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.doan.LeaderboardAdapter;
import com.example.doan.MainActivity;
import com.example.doan.MainMenu;
import com.example.doan.MyNotification;
import com.example.doan.R;
import com.example.doan.ReadWriteUserDetail;
import com.example.doan.Vocab;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderBoard extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ReadWriteUserDetail> list;
    DatabaseReference databaseReference;
    LeaderboardAdapter adapter;
    String a,b,c,d;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        ImageButton imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);

        // mãi mãi một cái bìm
        Button btnNotification = findViewById(R.id.btnNotification);


        btnNotification.setOnClickListener(v -> {
            Notification notification = new NotificationCompat.Builder(this, MyNotification.CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(a + " " + b)
                    .setContentText(c)
                    .build();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            NotificationManagerCompat.from(this).notify(index, notification);
            index+=1;
            RandomVoc();
        });
        // mãi mãi một cái bìm

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

    // mãi mãi một cái bìm
    public void RandomVoc() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String indexString = Integer.toString(index);
        DatabaseReference myRef = database.getReference("vocab").child("contracts").child(indexString);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Vocab vocab = snapshot.getValue(Vocab.class);
                if (vocab != null) {
                    a = vocab.word;
                    c = vocab.means;
                    b = vocab.spelling;
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
    // mãi mãi một cái bìm

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
                Collections.sort(list, new Comparator<ReadWriteUserDetail>() {
                    @Override
                    public int compare(ReadWriteUserDetail o1, ReadWriteUserDetail o2) {
                        return Integer.compare(Integer.parseInt(o2.getScore()), Integer.parseInt(o1.getScore()));
                    }
                });

                // Gán rank dựa trên thứ tự
                int rank = 1;
                for (ReadWriteUserDetail user : list) {
                    user.setRank(String.valueOf(rank++));
                }
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