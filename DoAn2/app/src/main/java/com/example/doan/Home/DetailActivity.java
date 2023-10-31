package com.example.doan.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.R;

public class DetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detalImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("Title");
            String desc = bundle.getString("Desc");
            int imageResource = bundle.getInt("Image");

            detailTitle.setText(title);
            detailDesc.setText(desc);
            detailImage.setImageResource(imageResource);
        }
    }
}