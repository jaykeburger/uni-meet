package com.example.unimeet3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        TextView username = (TextView) findViewById(R.id.username); //instance of textview
        TextView password = (TextView) findViewById(R.id.password); //instance of password
        TextView login_user = (TextView) findViewById(R.id.login); //instance of newuser

        MaterialButton register_button = (MaterialButton) findViewById(R.id.register_button); //instance of login_button

        String admin_username = "admin"; //temporary username fields, will check database for others
        String admin_password = "admin";

        register_button.setOnClickListener(new View.OnClickListener() { //creates click listener that will check if login_button is clicked
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals(admin_username) && password.getText().toString().equals(admin_password)) {
                    Toast.makeText(RegisterAcivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show(); //login successful will pop up
                    //TODO: REDIRECT TO HOME PAGE
                }
                else {
                    Toast.makeText(RegisterAcivity.this,"LOGIN FAILED", Toast.LENGTH_SHORT).show(); //login failed will pop up
                }
            }
        });

        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterAcivity.this,"CREATE ACCOUNT", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterAcivity.this, LoginActivity.class));
            }
        });
    }
}