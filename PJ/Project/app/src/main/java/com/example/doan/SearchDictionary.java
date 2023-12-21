package com.example.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.doan.GrammarCau.Fragment.About_us;
import com.example.doan.GrammarCau.Fragment.Home;
import com.example.doan.GrammarCau.Fragment.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SearchDictionary extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    NavigationView navigationView;
    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dictionary);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        if(savedInstanceState == null )
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Home()).commit();
            navigationView.setCheckedItem(R.id.nav_view);
        }

        fragmentManager = getSupportFragmentManager();
        openFragment(new Home());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int itemID = item.getItemId();
        if(itemID == R.id.nav_home)
        {
            openFragment(new Home());
        }
        else if(itemID == R.id.nav_settings)
        {
            openFragment(new Setting());
        }
        else if(itemID == R.id.nav_about)
        {
            openFragment(new About_us());
        }
        else if (itemID == R.id.account)
        {
            Intent intent = new Intent(this, Account.class);
            startActivity(intent);
        }
        else if (itemID == R.id.nav_logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}
