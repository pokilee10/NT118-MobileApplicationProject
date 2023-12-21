package com.example.doan;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Account extends AppCompatActivity {

    private Button changeInfo;
    private FirebaseAuth mAuth;
    private TextView tvusername, tvemail, tvphonenumber, tvaddress, tvrank;
    private ImageView avatar;
    private String username, email, phonenumber, address, rank;
    private FirebaseUser firebaseUser;

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
        avatar = findViewById(R.id.img_avatar);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        String userID = firebaseUser.getUid();

        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Change();
            }
        });



        showUserInfo(firebaseUser);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }


    private void initListener(){
        String userID = firebaseUser.getUid();

        FirebaseUser firebaseUser1 = FirebaseAuth.getInstance().getCurrentUser();
        String a = firebaseUser1.getDisplayName();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(userID);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onClickRequestPermission();
            }
        });
    }
    /*private void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            openGallery();
            return;
        }else if (this.checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            openGallery();
        }
        else {
            String [] permissions = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
            getActivity().requestPermissions(permissions,MY_REQUEST_CODE);
        }
    }*/
    private void showUserInfo(FirebaseUser firebaseUser)
    {

        String userID = firebaseUser.getUid();

        FirebaseUser firebaseUser1 = FirebaseAuth.getInstance().getCurrentUser();
        String a = firebaseUser1.getDisplayName();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(userID);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetail readWriteUserDetail = snapshot.getValue(ReadWriteUserDetail.class);
                if(readWriteUserDetail != null)
                {
                    username = readWriteUserDetail.username;
                    email = firebaseUser.getEmail();
                    phonenumber = readWriteUserDetail.password;

                    tvusername.setText(username);
                    tvemail.setText(email);
                    tvphonenumber.setText(phonenumber);
                }
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

    public void Change(){
        Intent intent = new Intent(this, Change.class);
        startActivity(intent);
    }
}