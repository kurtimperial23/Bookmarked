package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class USERSCREEN extends AppCompatActivity {

    ImageButton imagebutton10;
    ImageButton imagebutton11;
    ImageButton imagebutton12;
    TextView userName, addressText;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userscreen);

        getSupportActionBar().hide();

        userName = (TextView) findViewById(R.id.userName);
        addressText = (TextView) findViewById(R.id.addressText);

        DB = new DBHelper(this);
        String username = getIntent().getStringExtra("username");
        String SFName = DB.getUserFullName(username);
        userName.setText(SFName);

        String SAddress = DB.getAddress(username);
        addressText.setText(SAddress);

        imagebutton10 = (ImageButton) findViewById(R.id.homeButtom);
        imagebutton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imagebutton11 = (ImageButton) findViewById(R.id.cartButton);
        imagebutton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(USERSCREEN.this, CARTSCREEN.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

        CardView help = (CardView) findViewById(R.id.helpCenter);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(USERSCREEN.this, HelpCenter.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        CardView about = (CardView) findViewById(R.id.aboutCard);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(USERSCREEN.this, AboutPage.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}