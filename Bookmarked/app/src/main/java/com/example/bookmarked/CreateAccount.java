package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    private ImageButton createaccountSubmit_button, createaccountGoogle_button, createaccountFacebook_button;
    private TextView createaccountSignin_button;
    private Spinner SecQuest;
    private EditText FirstName, LastName, Address, ContactNumber, Email, Username, Password, SecAns;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().hide();

        ImageButton imgbutton8 =  (ImageButton) findViewById(R.id.createaccountSubmit_button);
        imgbutton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccountSubmit();
            }
        });

        FirstName = (EditText) findViewById(R.id.TextFname);
        LastName = (EditText) findViewById(R.id.TextLname);
        Address = (EditText) findViewById(R.id.TextAddress);
        ContactNumber = (EditText) findViewById(R.id.TextPhone);
        Email = (EditText) findViewById(R.id.TextEmail);
        Username = (EditText) findViewById(R.id.TextUsername);
        Password = (EditText) findViewById(R.id.TextPassword);
        SecQuest = (Spinner) findViewById(R.id.securityQuestion);
        SecAns = (EditText) findViewById(R.id.securityAnswer);

        DB = new DBHelper(this);


        TextView txtbutton4 = (TextView) findViewById(R.id.createaccountSignin_button);
        txtbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccountSignIn();
            }
        });
    }


    public void openCreateAccountSubmit() {
        String SFname = FirstName.getText().toString();
        String SLname = LastName.getText().toString();
        String SAddress = Address.getText().toString();
        String SNumber = ContactNumber.getText().toString();
        String SEmail = Email.getText().toString();
        String SUsername = Username.getText().toString();
        String SPassword = Password.getText().toString();
        String SAnswer = SecAns.getText().toString();
        int SQuestion = SecQuest.getSelectedItemPosition();

        if(!SFname.isEmpty() && !SLname.isEmpty() && !SAddress.isEmpty() && !SNumber.isEmpty() && !SEmail.isEmpty() && !SUsername.isEmpty() && !SPassword.isEmpty() && !SAnswer.isEmpty()){
            if(DB.isUnique("username",SUsername)){
                if(DB.isUnique("email",SEmail)){
                    boolean success = DB.addUser(SUsername, SPassword, SFname, SLname, SAddress, SNumber, SEmail, SQuestion, SAnswer);

                    if(success){
                        Toast.makeText(getApplicationContext(), "Account successfully created.", Toast.LENGTH_LONG).show();
                        DB.cleanup();
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Account creation failed.", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Email already used.", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Username is already taken.", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Please fill in all fields.", Toast.LENGTH_LONG).show();
        }
    }


    public void openCreateAccountSignIn() {
        DB.cleanup();
        finish();
    }
}