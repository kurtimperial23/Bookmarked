package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EMPTYCARTSCREEN extends AppCompatActivity {
 Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emptycartscreen);

        getSupportActionBar().hide();

        checkout = findViewById(R.id.checkout_cartpage);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EMPTYCARTSCREEN.this, CHECKOUTSCREEN.class);
                startActivity(intent);
            }
        });
    }
}