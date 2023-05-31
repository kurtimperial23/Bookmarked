package com.example.bookmarked;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookInfo extends AppCompatActivity {
    private TextView bookTitle, bookAuthor, bookPrice, bookGenres, bookSynopsis, bookPrice1;
    private ImageView bookImage;
    private ImageButton bookExit;
    private Button addCart;
    private String username;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        getSupportActionBar().hide();

        username = getIntent().getStringExtra("username");

        bookTitle = (TextView) findViewById(R.id.bookTitle);
        bookAuthor = (TextView) findViewById(R.id.bookAuthor);
        bookPrice = (TextView) findViewById(R.id.bookPrice);
        bookPrice1 = (TextView) findViewById(R.id.bookPrice1);
        bookGenres = (TextView) findViewById(R.id.bookGenres);
        bookSynopsis = (TextView) findViewById(R.id.bookSynopsis);
        bookImage = (ImageView) findViewById(R.id.bookImage);
        DB = new DBHelper(this);
        String STitle = getIntent().getStringExtra("bookTitle");
        String[] bookDetails = DB.bookInfo(STitle);
        if(bookDetails.length > 0){
            bookTitle.setText(bookDetails[0]);
            bookAuthor.setText(bookDetails[1]);
            bookGenres.setText(bookDetails[2]);
            bookPrice.setText("₱"+bookDetails[3]);
            bookPrice1.setText("₱"+bookDetails[3]);
            bookSynopsis.setText(bookDetails[4]);

            int picID = getResources().getIdentifier(bookDetails[5],"drawable",this.getPackageName());
            bookImage.setImageResource(picID);
        }

        bookExit = (ImageButton) findViewById(R.id.bookExit);
        bookExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addCart = (Button) findViewById(R.id.addCart);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.addToCart(username,bookDetails[0]);
                Toast.makeText(getApplicationContext(), "Book added to cart.", Toast.LENGTH_LONG).show();
            }
        });

    }
}
