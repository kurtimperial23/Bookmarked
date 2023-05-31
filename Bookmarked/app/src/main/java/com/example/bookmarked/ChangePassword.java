package com.example.bookmarked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    private EditText pass1, pass2, answer;
    private TextView question;
    private DBHelper DB;
    private String SavedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getSupportActionBar().hide();

        question = (TextView) findViewById(R.id.SecQuestion);
        answer = (EditText) findViewById(R.id.SecAnswer);
        pass1 = (EditText) findViewById(R.id.editTextTextPassword);
        pass2 = (EditText) findViewById(R.id.editTextTextPassword2);
        DB = new DBHelper(this);

        question.setText(getQuestion());


        ImageButton imgbutton7 =  (ImageButton) findViewById(R.id.recoverpassSubmit_button);
        imgbutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginMainChangePass();
            }
        });
    }

    public void openLoginMainChangePass() {
        String SAnswer = answer.getText().toString();
        String SPass1 = pass1.getText().toString();
        String SPass2 = pass2.getText().toString();
        String SEmail = getIntent().getStringExtra("email");
        if (SAnswer.equals(SavedAnswer)){
            if(SPass1.equals(SPass2))
            {
                boolean success = DB.changePassEmail(SEmail, SPass1);
                if (success) {
                    DB.cleanup();
                    Toast.makeText(getApplicationContext(), "Password changed successfully!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password change unsuccessful. Please try again.", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Passwords do not match. Please try again.", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Incorrect security answer. Please try again.", Toast.LENGTH_LONG).show();
        }
    }

    public String getQuestion(){
        String SEmail = getIntent().getStringExtra("email");
        String[] reply = DB.getQuestion(SEmail);
        //Log.d("Bookmarked Debug","String 1 - "+reply[0]);
        //Log.d("Bookmarked Debug","String 2 - "+reply[1]);
        if(!reply[0].equals("-1")){
            int i = Integer.parseInt(reply[0]);
            SavedAnswer = reply[1];
            String[] questions = getResources().getStringArray(R.array.security_questions);
            return questions[i];
        }
        else{
            return "";
        }
    }
}