package com.example.android.quizone;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvUserName;
    TextView tvEmail;
    TextView tvContent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar detailsToolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(detailsToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvUserName = findViewById(R.id.detail_userName);
        tvEmail = findViewById(R.id.detail_email);
        tvContent = findViewById(R.id.detail_content);
        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        tvUserName.setText(sharedPreferences.getString("name", null));
        tvEmail.setText(sharedPreferences.getString("email",null));
        tvContent.setText(sharedPreferences.getString("content",null));
    }
}
