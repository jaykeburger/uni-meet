package com.example.unimeet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username = (TextView) findViewById(R.id.username); //instance of textview
        TextView password = (TextView) findViewById(R.id.password); //instance of password
        TextView new_user = (TextView) findViewById(R.id.newuser); //instance of newuser
        TextView forgot_password = (TextView) findViewById(R.id.forgotpassword); //instance of forgotpassword

        MaterialButton login_button = (MaterialButton) findViewById(R.id.login_button); //instance of login_button

        String admin_username = "admin"; //temporary username fields, will check database for others
        String admin_password = "admin";

        login_button.setOnClickListener(new View.OnClickListener() { //creates click listener that will check if login_button is clicked
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals(admin_username) && password.getText().toString().equals(admin_password)) {
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show(); //login successful will pop up
                    //TODO: REDIRECT TO HOME PAGE
                }
                else {
                    Toast.makeText(MainActivity.this,"LOGIN FAILED", Toast.LENGTH_SHORT).show(); //login failed will pop up
                }
            }
        });

        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"CREATE ACCOUNT", Toast.LENGTH_SHORT).show();
                //TODO: REDIRECT TO SIGN UP PAGE
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"FORGOT PASSWORD", Toast.LENGTH_SHORT).show();
                //TODO: REDIRECT TO FORGOT PASSWORD PAGE
            }
        });

    }
}