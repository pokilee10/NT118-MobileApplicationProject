package com.example.doan;

import android.app.AlertDialog;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassDialog extends AppCompatDialogFragment {

    private TextInputLayout currentPass, newpassword, verifypassword;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser = Account.firebaseUser;
    private String userID = Account.userid;

    private Context mContext;

    public ChangePassDialog(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_change_pass, null);

        builder.setView(view)
                .setTitle("Change Password")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ChangePass();
                    }
                });

        currentPass = view.findViewById(R.id.CurentPass);
        newpassword = view.findViewById(R.id.ChangePass);
        verifypassword = view.findViewById(R.id.VerifyChangePass);



        return builder.create();
    }

    private void ChangePass()
    {
        String currpass = String.valueOf(currentPass.getEditText().getText().toString().trim());
        String newpass = String.valueOf(newpassword.getEditText().getText().toString().trim());
        String verifypass = String.valueOf(verifypassword.getEditText().getText().toString().trim());

        Dialog dialog = new Dialog(getActivity());
        if (currpass.isEmpty() || newpass.isEmpty() || verifypass.isEmpty() ) {
            // Hiển thị thông báo nếu EditText trống
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Please enter all information !!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Đóng Dialog cảnh báo
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }
        if (!newpass.matches(verifypass)) {
            // Hiển thị thông báo nếu EditText trống
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Verify password and your new password must be the same !!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Đóng Dialog cảnh báo
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }
        if (currpass.matches(newpass)) {
            // Hiển thị thông báo nếu EditText trống
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Your new password cannot be the same as previous one !!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Đóng Dialog cảnh báo
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }

            AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), currpass);
            firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    firebaseUser.updatePassword(newpass).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("Change password successful !!!")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                // Đóng Dialog cảnh báo
                                                dialog.dismiss();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("You must enter your current password !!!")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                // Đóng Dialog cảnh báo
                                                dialog.dismiss();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();
                            }
                        }
                    });
                }
            });


            dialog.dismiss();

    }
}
