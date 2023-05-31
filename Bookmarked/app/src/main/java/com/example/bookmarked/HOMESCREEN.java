package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

public class HOMESCREEN extends AppCompatActivity {
    ImageButton imagebutton2, imagebutton3;
    ImageButton[] bookButton;
    TextView userName;
    SearchView searchBar;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        getSupportActionBar().hide();


        userName = (TextView) findViewById(R.id.textView10);
        DB = new DBHelper(this);
        String username = getIntent().getStringExtra("username");
        String SFName = DB.getUserFirstName(username);
        userName.setText(SFName);


        imagebutton2 =(ImageButton) findViewById(R.id.cartButton);

        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, CARTSCREEN.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });


        imagebutton3 =(ImageButton) findViewById(R.id.userinfoButton);

        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, USERSCREEN.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        searchBar = (SearchView) findViewById(R.id.searchBar);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(HOMESCREEN.this, SearchResults.class);
                intent.putExtra("query",s);
                intent.putExtra("username",username);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        /*
        setter1 =(ImageButton) findViewById(R.id.set1);
        setter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Coiling Dragon");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        */
        bookButton = new ImageButton[18];

        bookButton[0] = findViewById(R.id.Bookpreview1);
        bookButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Harry Potter and the Philosopher's Stone");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[1] = findViewById(R.id.Bookpreview2);
        bookButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Emperor of Solo Play");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[2] = findViewById(R.id.Bookpreview3);
        bookButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Percy Jackson and The Olympians #1: The Lightning Thief");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[3] = findViewById(R.id.Bookpreview4);
        bookButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Warlock of the Magus World");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[4] = findViewById(R.id.Bookpreview5);
        bookButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "The Legendary Mechanic");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[5] = findViewById(R.id.Bookpreview6);
        bookButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Castle of Black Iron");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[6] = findViewById(R.id.Bookpreview7);
        bookButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "The Legendary Mechanic");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[7] = findViewById(R.id.Bookpreview8);
        bookButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Birth of the Demonic Sword");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[8] = findViewById(R.id.Bookpreview9);
        bookButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Super Gene");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[9] = findViewById(R.id.Bookpreview10);
        bookButton[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "I Shall Seal the Heavens");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[10] = findViewById(R.id.Bookpreview11);
        bookButton[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Coiling Dragon");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[11] = findViewById(R.id.Bookpreview12);
        bookButton[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Warlock of the Magus World");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[12] = findViewById(R.id.Bookpreview13);
        bookButton[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Harry Potter and the Philosopher's Stone");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[13] = findViewById(R.id.Bookpreview14);
        bookButton[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Percy Jackson and The Olympians #1: The Lightning Thief");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[14] = findViewById(R.id.Bookpreview15);
        bookButton[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "The Hunger Games");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[15] = findViewById(R.id.Bookpreview16);
        bookButton[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "The Maze Runner");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[16] = findViewById(R.id.Bookpreview17);
        bookButton[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "Miss Peregrines Home For Peculiar Children");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        bookButton[17] = findViewById(R.id.Bookpreview18);
        bookButton[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOMESCREEN.this, BookInfo.class);
                intent.putExtra("bookTitle", "The Return");
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}