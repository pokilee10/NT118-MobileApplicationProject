package com.example.doan;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.doan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class EditProfileDialog  extends AppCompatDialogFragment {
    private TextInputLayout editUsername, editPhoneNumber, editAdress;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser = Account.firebaseUser;
    private EditProfileDialogListner listner;
    private String userID = Account.userid;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_edit_profile, null);

        builder.setView(view)
                .setTitle("Change Profile")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        UpdateProfile();
                    }
                });

        editUsername = view.findViewById(R.id.EditUsername);
        editPhoneNumber = view.findViewById(R.id.EditPhoneNumber);
        editAdress = view.findViewById(R.id.EditAddress);



        return builder.create();
    }

    private void UpdateProfile()
    {
        String username = String.valueOf(editUsername.getEditText().getText().toString().trim());
        String phoneNumber = String.valueOf(editPhoneNumber.getEditText().getText().toString().trim());
        String address = String.valueOf(editAdress.getEditText().getText().toString().trim());

        Map<String, Object> updateData = new HashMap<>();
        if (!username.isEmpty()) {
            updateData.put("username", username);
        }
        if (!phoneNumber.isEmpty()) {
            updateData.put("phonenumber", phoneNumber);
        }
        if (!address.isEmpty()) {
            updateData.put("address", address);
        }


        ReadWriteUserDetail readWriteUserDetail = new ReadWriteUserDetail(username, phoneNumber, address, 1);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

        databaseReference.child(userID).updateChildren(updateData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Cập nhật display name của user
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username)
                            .build();

                    firebaseUser.updateProfile(profileChangeRequest);
                    listner.applyText(username, phoneNumber, address);
                } else {
                    // Xử lý khi cập nhật không thành công
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listner = (EditProfileDialogListner) context;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() +
                    "must implement EditProfileDialog");

        }
    }

    public interface EditProfileDialogListner
    {
        void applyText(String username, String phonenumber, String address);
    }
}
