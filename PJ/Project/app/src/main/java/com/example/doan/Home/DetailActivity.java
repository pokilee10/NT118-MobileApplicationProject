package com.example.doan.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.R;

public class DetailActivity extends AppCompatActivity {

    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detalImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int imageResource = bundle.getInt("Image");
            detailImage.setImageResource(imageResource);
        }
    }
}