package com.example.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.GrammarCau.Fragment.About_us;
import com.example.doan.GrammarCau.Fragment.Home;
import com.example.doan.GrammarCau.Fragment.SearchDictionary;
import com.example.doan.GrammarCau.Fragment.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    NavigationView navigationView;
    FirebaseUser user;
    FirebaseAuth auth;
    private AutoCompleteTextView searchEditText;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        searchEditText = findViewById(R.id.Search_bar);

        List<String> vocabularyList = readVocabularyFromFile("vocabulary.txt");

        // Tạo ArrayAdapter cho AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                vocabularyList
        );

        searchEditText.setAdapter(adapter);

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SearchDictionary searchDictionary = new SearchDictionary();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                Bundle data = new Bundle();
                data.putString("word", searchEditText.getText().toString());

                searchDictionary.setArguments(data);
                fragmentTransaction.replace(R.id.frame_layout, searchDictionary).commit();

                return true;
            }
        });

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

    private List<String> readVocabularyFromFile(String fileName) {
        List<String> vocabularyList = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                vocabularyList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vocabularyList;
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

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}