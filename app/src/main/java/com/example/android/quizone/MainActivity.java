package com.example.android.quizone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText email;
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        content = findViewById(R.id.content);
        if (savedInstanceState != null) {
            String userNameValue = savedInstanceState.getString("username");
            String emailValue = savedInstanceState.getString("email");
            String contentValue = savedInstanceState.getString("content");

            userName.setText(userNameValue);
            email.setText(emailValue);
            content.setText(contentValue);
        }


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
