package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ONLINE_PAYMENT_SCREEN extends AppCompatActivity {
    Button checkout_online;
    RadioGroup payment;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_payment_screen);

        getSupportActionBar().hide();

        checkout_online = (Button) findViewById(R.id.checkout_onlinepayment2);
        payment = (RadioGroup) findViewById(R.id.paymentMethod);

        checkout_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int met = payment.getCheckedRadioButtonId();
                if(met == -1){
                    Toast.makeText(getApplicationContext(), "Please select a payment method before proceeding.", Toast.LENGTH_LONG).show();
                }
                else{
                    RadioButton rad = findViewById(met);
                    String SMethod = rad.getText().toString();
                    Intent intent = new Intent(ONLINE_PAYMENT_SCREEN.this,  PaymentProcessing.class);
                    setResult(RESULT_OK, null);
                    username = getIntent().getStringExtra("username");
                    intent.putExtra("username", username);
                    intent.putExtra("payment",SMethod);
                    startActivity(intent);
                    finish();
                }

            }
        });


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