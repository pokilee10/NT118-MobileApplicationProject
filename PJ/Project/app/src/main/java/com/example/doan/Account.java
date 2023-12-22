package com.example.doan;

import static android.app.PendingIntent.getActivity;



import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


import java.io.IOException;

public class Account extends AppCompatActivity {

    public static final int PICK_IMAGES_REQUEST = 1;
    private Button changeInfo;
    private FirebaseAuth mAuth;
    private TextView tvusername, tvemail, tvphonenumber, tvaddress, tvrank;
    private ImageView avatar, avatar2;
    private String username, email, phonenumber, address, rank;
    private FirebaseUser firebaseUser;
    private StorageReference storageReference;
    private Uri uriImage;

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
        avatar2 = findViewById(R.id.img_avatar2);
        tvaddress = findViewById(R.id.tvAddress);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        String userID = firebaseUser.getUid();
        storageReference = FirebaseStorage.getInstance().getReference("DisplayPics");

        Uri uri = firebaseUser.getPhotoUrl();
        Picasso.get().load(uri).into(avatar);
        Glide.with(Account.this).load(uri).into(avatar);

        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Change();
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
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


    private void openFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGES_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            uriImage = data.getData();
            avatar.setImageURI(uriImage);
            StorageReference fileReference = storageReference.child(mAuth.getCurrentUser().getUid() + "."
             + getfileExtension(uriImage));

            fileReference.putFile(uriImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Uri downloadUri = uri;
                            firebaseUser = mAuth.getCurrentUser();

                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                    .setPhotoUri(downloadUri).build();
                            firebaseUser.updateProfile(profileChangeRequest);
                        }
                    });
                }
            });
    }


    private String getfileExtension(Uri uri)
    {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void showUserInfo(FirebaseUser firebaseUser)
    {

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
                    username = readWriteUserDetail.username;
                    email = firebaseUser.getEmail();
                    phonenumber = readWriteUserDetail.phonenumber;
                    address = readWriteUserDetail.address;
                    rank = readWriteUserDetail.rank;

                    tvusername.setText(username);
                    tvemail.setText(email);
                    tvphonenumber.setText(phonenumber);
                    tvrank.setText(rank);
                    tvaddress.setText(address);
                    Glide.with(Account.this).load(firebaseUser.getPhotoUrl()).error(R.drawable.manavatar).into(avatar);
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


    /*private void initListener(){
        String userID = firebaseUser.getUid();

        FirebaseUser firebaseUser1 = FirebaseAuth.getInstance().getCurrentUser();
        String a = firebaseUser1.getDisplayName();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(userID);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRequestPermission();
            }
        });
    }

    private void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            openGallary();
            return;
        }else if (Account.this.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            openGallary();
        }
        else {
            String [] permissions = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
            this.requestPermissions(permissions, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == MY_REQUEST_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                openGallary();
            }
        }
    }

    public void openGallary()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activityResultLauncher.launch(Intent.createChooser(intent, "Select your picture"));
    }*/
}