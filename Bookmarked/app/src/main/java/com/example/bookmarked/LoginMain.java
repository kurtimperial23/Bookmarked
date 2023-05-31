package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMain<TextButton> extends AppCompatActivity {

    EditText username, password;
    private ImageButton signinLogin_button, googleLogin_button, facebookLogin_button;
    private TextView forgotpassLogin_button, signupLogin_button;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.emailLogin_input);
        password = (EditText) findViewById(R.id.passwordLogin_input);

        DB = new DBHelper(this);

        ImageButton imgbutton1 = (ImageButton) findViewById(R.id.siginLogin_button);
        imgbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeToBookmarked();
            }
        });

        ImageButton imgbutton2 = (ImageButton) findViewById(R.id.googleLogin_button);
        imgbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleLogin();
            }
        });

        ImageButton imgbutton3 = (ImageButton) findViewById(R.id.facebookLogin_button);
        imgbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebookLogin();
            }
        });

        TextView txtbutton1 = (TextView) findViewById(R.id.forgotpassLogin_button);
        txtbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassword();
            }
        });

        TextView txtbutton2 = (TextView) findViewById(R.id.signupLogin_button);
        txtbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });


    }


    public void openWelcomeToBookmarked() {
        String SUsername = username.getText().toString();
        String SPassword = password.getText().toString();

        boolean success = DB.loginCheck(SUsername, SPassword);

        if (success){
            boolean isFirst = DB.firstLogin(SUsername,SPassword);
            Intent intent1;
            if(isFirst){
                intent1 = new Intent(this, WelcomeToBookmarked.class);
            }
            else{
                intent1 = new Intent(this, HOMESCREEN.class);
            }
            intent1.putExtra("username",SUsername);
            DB.cleanup();
            startActivity(intent1);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect username or password. Please try again.", Toast.LENGTH_LONG).show();
        }
    }


    public void openGoogleLogin() {
        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent2);
    }

    public void openFacebookLogin() {
        Uri uri = Uri.parse("http://www.facebook.com"); // missing 'http://' will cause crashed
        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent3);
    }

    public void openForgotPassword() {
        Intent intent4 = new Intent(this, ForgotPassword.class);
        startActivity(intent4);
    }

    public void openSignUp() {
        Intent intent5 = new Intent(this, CreateAccount.class);
        startActivity(intent5);
    }
}