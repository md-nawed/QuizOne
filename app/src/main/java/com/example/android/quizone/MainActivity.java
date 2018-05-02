package com.example.android.quizone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText email;
    EditText content;

    Button button;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        content = findViewById(R.id.content);
        button = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        if (savedInstanceState != null) {
            String userNameValue = savedInstanceState.getString("username");
            String emailValue = savedInstanceState.getString("email");
            String contentValue = savedInstanceState.getString("content");

            userName.setText(userNameValue);
            email.setText(emailValue);
            content.setText(contentValue);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameValue = userName.getText().toString();
                String emailValue = email.getText().toString();
                String contentValue = content.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", userNameValue);
                editor.putString("email", emailValue);
                editor.putString("content", contentValue);
                editor.commit();
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        content = findViewById(R.id.content);

        String userNameValue = String.valueOf(userName.getText());
        String emailValue = String.valueOf(email.getText());
        String contentValue = String.valueOf(content.getText());
        outState.putString("username", userNameValue);
        outState.putString("email", emailValue);
        outState.putString("content", contentValue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_details:
                Intent intent = new Intent(this, DetailsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
