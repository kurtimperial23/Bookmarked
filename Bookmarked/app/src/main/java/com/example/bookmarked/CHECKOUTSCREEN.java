package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CHECKOUTSCREEN extends AppCompatActivity {
    RadioButton online, cod;
    Button order;
    TextView tax1, itemsubtotal1, shippingfee1, voucher1, subtotal1, totalpayment1;
    EditText fullname, address, phonenum;
    RadioGroup paymentType;
    double item_subtotal, dTax, dTot, dVoucher, dShipping, dSubtotal, dFinal;
    int total_items;
    LinearLayout cart;
    DBHelper DB;
    String username;
    String tax_final, shipfee_final, voucher_final, subtotal_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkoutscreen);

        getSupportActionBar().hide();

        username = getIntent().getStringExtra("username");
        DB = new DBHelper(this);

        fullname = (EditText) findViewById(R.id.namecheckout);
        phonenum = (EditText) findViewById(R.id.numbercheckout);
        address = (EditText) findViewById(R.id.addresscheckout);
        String[] details = DB.getShipping(username);
        fullname.setText(details[0]);
        phonenum.setText(details[1]);
        address.setText(details[2]);

        subtotal1 = (TextView) findViewById(R.id.subtotal);
        itemsubtotal1 = (TextView) findViewById(R.id.itemsubtotal);
        tax1 = (TextView) findViewById(R.id.tax);
        shippingfee1 = (TextView) findViewById(R.id.shippingfee);
        voucher1 = (TextView) findViewById(R.id.voucher);
        totalpayment1 = (TextView) findViewById(R.id.totalpayment);
        online = (RadioButton) findViewById(R.id.payPal) ;
        cod = (RadioButton) findViewById(R.id.payCard);
        cart = (LinearLayout) findViewById(R.id.cartView2);

        Cursor DBCart = DB.retrieveCart(username);
        total_items = DBCart.getCount();
        if(DBCart.getCount() > 0){
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

        paymentType = (RadioGroup) findViewById(R.id.paymentoption);

        order = (Button) findViewById(R.id.placeorder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOrder();
            }
        });

    }

    public void updatePrice(double value){
        if(value < 0){
            total_items -= 1;
        }
        item_subtotal += value;
        dTot = item_subtotal/1.12;
        dTax = dTot*0.12;
        dShipping = 50;
        if(total_items > 5){
            dShipping += (total_items-5)*8;
        }
        dSubtotal = item_subtotal + dShipping;
        dVoucher = (dSubtotal*-0.05);
        dFinal = dSubtotal+dVoucher;

        tax1.setText("₱"+String.format("%.2f",dTax));
        itemsubtotal1.setText("₱"+String.format("%.2f",dTot));
        shippingfee1.setText("₱"+String.format("%.2f",dShipping));
        voucher1.setText("₱"+String.format("%.2f",dVoucher));
        subtotal1.setText("₱"+String.format("%.2f",dSubtotal));
        totalpayment1.setText("₱"+String.format("%.2f",dFinal));
    }

    public void processOrder(){
        int order = paymentType.getCheckedRadioButtonId();
        if(order == -1){
            Toast.makeText(getApplicationContext(), "Please select a payment method before proceeding.", Toast.LENGTH_LONG).show();
        }
        else{
            Intent next;
            if(order == R.id.payPal){
                next = new Intent(this, ONLINE_PAYMENT_SCREEN.class);
                next.putExtra("username", username);
                startActivityForResult(next,1337);
            }
            else{
                next = new Intent(this, ORDERSUCCESSFUL.class);
                setResult(RESULT_OK, null);
                next.putExtra("username", username);
                next.putExtra("payment","Cash on delivery");
                startActivity(next);
                this.finish();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1337) {
            if (resultCode == RESULT_OK) {
                setResult(RESULT_OK, null);
                this.finish();
            }
        }
    }
}