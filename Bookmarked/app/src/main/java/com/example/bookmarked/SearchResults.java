package com.example.bookmarked;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SearchResults extends AppCompatActivity {

    TextView searchText;
    LinearLayout searchView;
    DBHelper DB;
    String username, searchArg;
    SearchView searchBar;
    ImageButton home, cart, user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();
        username = getIntent().getStringExtra("username");

        searchView = (LinearLayout) findViewById(R.id.searchView);
        searchText = (TextView) findViewById(R.id.searchText);

        searchArg = getIntent().getStringExtra("query");

        searchText.setText("Search Results for - "+searchArg);

        DB = new DBHelper(this);
        Cursor DBSearch = DB.searchBooks(searchArg);
        if(DBSearch.getCount() > 0){
            DBSearch.moveToFirst();
            while(!DBSearch.isAfterLast()){
                View view = getLayoutInflater().inflate(R.layout.activity_search_entry,null);

                String STitle = DBSearch.getString(0);
                TextView title = view.findViewById(R.id.title);
                TextView author = view.findViewById(R.id.author);
                TextView genre = view.findViewById(R.id.genre);
                TextView price = view. findViewById(R.id.price);
                CardView card = view.findViewById(R.id.card);
                title.setText(STitle);
                author.setText(DBSearch.getString(1));
                genre.setText(DBSearch.getString(2));
                price.setText("₱"+DBSearch.getString(3));

                ImageView picture = view.findViewById(R.id.picture);
                int picID = getResources().getIdentifier(DBSearch.getString(5),"drawable",getPackageName());
                picture.setImageResource(picID);

                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SearchResults.this, BookInfo.class);
                        intent.putExtra("bookTitle", STitle);
                        intent.putExtra("username", username);
                        startActivity(intent);
                    }
                });

                searchView.addView(view);
                DBSearch.moveToNext();
            }
        }
        else{

        }
        DBSearch.close();

        searchBar = (SearchView) findViewById(R.id.searchBar);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(SearchResults.this, SearchResults.class);
                intent.putExtra("query",s);
                intent.putExtra("username",username);
                startActivity(intent);
                finish();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        home = (ImageButton) findViewById(R.id.homeButtom);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cart =(ImageButton) findViewById(R.id.cartButton);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResults.this, CARTSCREEN.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });


        user =(ImageButton) findViewById(R.id.userinfoButton);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResults.this, USERSCREEN.class);
                intent.putExtra("username",username);
                startActivity(intent);
                finish();
            }
        });
    }
}
