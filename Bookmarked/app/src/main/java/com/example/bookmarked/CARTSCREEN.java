package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CARTSCREEN extends AppCompatActivity {
    Button checkout;
    TextView total;
    double item_subtotal;
    LinearLayout cart;
    ImageButton backButton;
    DBHelper DB;
    int items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartscreen);

        getSupportActionBar().hide();
        String username = getIntent().getStringExtra("username");
        item_subtotal = 0;
        total = findViewById(R.id.total_cartpage);

        // another
        cart = (LinearLayout) findViewById(R.id.cartView);

        DB = new DBHelper(this);
        Cursor DBCart = DB.retrieveCart(username);
        items = DBCart.getCount();
        if(items > 0){
            DBCart.moveToFirst();
            while(!DBCart.isAfterLast()){
                View view = getLayoutInflater().inflate(R.layout.activity_book_entry,null);

                String UID = DBCart.getString(0);
                String[] bookInfo = DB.bookInfo(DBCart.getString(2));


                TextView title = view.findViewById(R.id.title);
                TextView author = view.findViewById(R.id.author);
                TextView genre = view.findViewById(R.id.genre);
                TextView price = view. findViewById(R.id.price);
                title.setText(bookInfo[0]);
                author.setText(bookInfo[1]);
                genre.setText(bookInfo[2]);
                price.setText("₱"+bookInfo[3]);
                updatePrice(Double.parseDouble(bookInfo[3]));

                ImageView picture = view.findViewById(R.id.picture);
                int picID = getResources().getIdentifier(bookInfo[5],"drawable",getPackageName());
                picture.setImageResource(picID);

                ImageButton removeButton = view.findViewById(R.id.removeButton);
                removeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DB.removeFromCart(UID);
                        updatePrice(Double.parseDouble(bookInfo[3])*-1);
                        cart.removeView(view);
                    }
                });
                cart.addView(view);
                DBCart.moveToNext();
            }
        }
        DBCart.close();

        backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        checkout = (Button) findViewById(R.id.checkout_cartpage);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(items > 0){
                    Intent intent = new Intent(CARTSCREEN.this, CHECKOUTSCREEN.class);
                    intent.putExtra("username", username);
                    startActivityForResult(intent,4826);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Your cart is empty.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void updatePrice(double value){
        item_subtotal += value;
        total.setText("₱"+item_subtotal+"");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4826) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }
}