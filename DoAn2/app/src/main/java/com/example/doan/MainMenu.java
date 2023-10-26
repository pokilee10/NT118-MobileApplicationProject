package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageButton imbMenu = (ImageButton) findViewById(R.id.imgbtn_menu);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        imbMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });


    }
}