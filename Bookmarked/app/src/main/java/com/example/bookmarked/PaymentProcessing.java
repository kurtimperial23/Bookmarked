package com.example.bookmarked;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentProcessing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_processing);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PaymentProcessing.this, ORDERSUCCESSFUL.class);
                String username = getIntent().getStringExtra("username");
                intent.putExtra("username", username);
                String SMethod = getIntent().getStringExtra("payment");
                intent.putExtra("payment",SMethod);
                startActivity(intent);
                finish();
            }
        },3000);
    }

}
