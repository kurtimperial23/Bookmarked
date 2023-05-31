package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomeToBookmarked extends AppCompatActivity {
    ImageButton welcome;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        welcome = findViewById(R.id.imageButton2);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeToBookmarked.this, HOMESCREEN.class);
                String username = getIntent().getStringExtra("username");
                intent.putExtra("username",username);
                finish();
                startActivity(intent);
            }
        });

    }
}