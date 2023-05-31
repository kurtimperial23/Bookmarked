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

public class ForgotPassword extends AppCompatActivity {

    private ImageButton forgotpassSubmit_button, forgotpassGoogle_button, forgotpassFacebook_submit;
    private TextView forgotpassSignup_button;
    private EditText email;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().hide();

        email = (EditText) findViewById(R.id.forgotpassEmail_input);
        DB = new DBHelper(this);

        ImageButton imgbutton4 =  (ImageButton) findViewById(R.id.forgotpassSubmit_button);
        imgbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangePassword();
            }
        });

        ImageButton imgbutton5 =  (ImageButton) findViewById(R.id.forgotpassGoogle_button);
        imgbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleLoginForgotPass();
            }
        });

        ImageButton imgbutton6 =  (ImageButton) findViewById(R.id.forgotpassFacebook_submit);
        imgbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebookLoginForgotPass();
            }
        });

        TextView txtbutton3 = (TextView) findViewById(R.id.forgotpassSignup_button);
        txtbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignIn();
            }
        });
    }


    public void openChangePassword() {
        String SEmail = email.getText().toString();
        if (!SEmail.isEmpty()){
            boolean isInDB = DB.checkEmail(SEmail);
            if (isInDB) {
                Intent intent6 = new Intent(this, ChangePassword.class);
                intent6.putExtra("email",SEmail);
                startActivity(intent6);
                DB.cleanup();
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "Incorrect Email. Please try again.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Email can't be blank. Please try again.", Toast.LENGTH_LONG).show();
        }
    }

    public void openGoogleLoginForgotPass() {
        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent7 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent7);
    }

    public void openFacebookLoginForgotPass() {
        Uri uri = Uri.parse("http://www.facebook.com"); // missing 'http://' will cause crashed
        Intent intent8 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent8);
    }

    public void openSignIn() {
        Intent intent9 = new Intent(this, LoginMain.class);
        startActivity(intent9);
    }
}