package com.example.doan;

import static android.app.PendingIntent.getActivity;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Account extends AppCompatActivity implements EditProfileDialog.EditProfileDialogListner {

    public static final int PICK_IMAGES_REQUEST = 1;
    private FirebaseAuth mAuth;
    private TextView tvusername, tvemail, tvphonenumber, tvaddress, tvrank;
    private ImageView avatar;
    private String username, email, phonenumber, address, rank;
    private StorageReference storageReference;
    private Uri uriImage;
    public static String userid;
    public static FirebaseUser firebaseUser;
    private TextView tv_ChangePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageButton back = (ImageButton) findViewById(R.id.imgbtn_back);
        ImageButton edit_profile = (ImageButton) findViewById(R.id.img_edit_profile);
        tvusername = findViewById(R.id.tvName);
        tvemail = findViewById(R.id.tvEmail);
        tvphonenumber = findViewById(R.id.tvPhonenumber);
        tvrank = findViewById(R.id.tvRank);
        avatar = findViewById(R.id.img_avatar);
        tvaddress = findViewById(R.id.tvAddress);
        tv_ChangePass = findViewById(R.id.txtbtn_changpass);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        userid = firebaseUser.getUid();
        storageReference = FirebaseStorage.getInstance().getReference("DisplayPics");

        Uri uri = firebaseUser.getPhotoUrl();
        Picasso.get().load(uri).into(avatar);
        Glide.with(Account.this).load(uri).into(avatar);


        tv_ChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialgChangPass();
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialgEditProfile();
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


    public void openDialgChangPass()
    {
        ChangePassDialog changePassDialog = new ChangePassDialog(this);
        changePassDialog.show(getSupportFragmentManager(), "Change Password");
    }

    public void openDialgEditProfile()
    {
        EditProfileDialog editProfileDialog = new EditProfileDialog();
        editProfileDialog.show(getSupportFragmentManager(), "Edit profile");
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

    @Override
    public void applyText(String username, String phonenumber, String address) {
        tvusername.setText(username);
        tvphonenumber.setText(phonenumber);
        tvaddress.setText(address);
    }
}