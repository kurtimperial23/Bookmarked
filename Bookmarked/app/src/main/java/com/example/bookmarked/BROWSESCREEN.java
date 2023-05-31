package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BROWSESCREEN extends AppCompatActivity {
    ImageButton imagebutton4, imagebutton5, imagebutton6;
    ImageButton MP, BTTH, CD, COBI;
    int price1 = 500, price2 = 600, price3 = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsescreen);

        getSupportActionBar().hide();

        imagebutton4 =(ImageButton) findViewById(R.id.homescreen2);

        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, HOMESCREEN.class);
                startActivity(intent);
            }
        });

        imagebutton5 =(ImageButton) findViewById(R.id.cartscreen2);

        imagebutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, EMPTYCARTSCREEN.class);
                startActivity(intent);
            }
        });

        imagebutton6 =(ImageButton) findViewById(R.id.userscreen2);

        imagebutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, USERSCREEN.class);
                startActivity(intent);
            }
        });
                    //  IMAGE BUTTON FOR BOOKS //

        MP =(ImageButton) findViewById(R.id.monsterParadise);

        MP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, CARTSCREEN.class);
                intent.putExtra("image", R.drawable.monster_paradise_cart);
                intent.putExtra("key", Integer.toString(price3));
                startActivity(intent);
            }
        });

        BTTH=(ImageButton) findViewById(R.id.battleThroughTheHeavens);

        BTTH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, CARTSCREEN.class);
                intent.putExtra("image", R.drawable.battle_through_the_heavens_cart);
                intent.putExtra("key", Integer.toString(price2));
                startActivity(intent);
            }
        });

        CD =(ImageButton) findViewById(R.id.coilingDragon);

        CD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, CARTSCREEN.class);
                intent.putExtra("image", R.drawable.coiling_dragon_cart);
                intent.putExtra("key", Integer.toString(price1));
                startActivity(intent);
            }
        });

        COBI =(ImageButton) findViewById(R.id.castleOfBlackIron);

        COBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BROWSESCREEN.this, CARTSCREEN.class);
                intent.putExtra("image", R.drawable.castle_of_black_iron_cart);
                intent.putExtra("key", Integer.toString(price1));
                startActivity(intent);
            }
        });
    }
}