package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ORDERSUCCESSFUL extends AppCompatActivity {
    ImageButton homepage;
    ImageButton userpage;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersuccessful);

        getSupportActionBar().hide();

        DB = new DBHelper(this);
        String username = getIntent().getStringExtra("username");
        String payment = getIntent().getStringExtra("payment");
        DB.addSale(username,payment);

        homepage =(ImageButton) findViewById(R.id.homebutton);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ORDERSUCCESSFUL.this, HOMESCREEN.class);
                String username = getIntent().getStringExtra("username");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        userpage =(ImageButton) findViewById(R.id.profilebutton);

        userpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ORDERSUCCESSFUL.this, USERSCREEN.class);
                String username = getIntent().getStringExtra("username");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}