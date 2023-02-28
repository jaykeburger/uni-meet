package com.example.unimeet3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.BreakIterator;

public class RegisterAcivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView username = (TextView) findViewById(R.id.username); //instance of textview
    TextView password = (TextView) findViewById(R.id.password); //instance of password
    TextView login_user = (TextView) findViewById(R.id.login); //instance of newuser

    MaterialButton register_button = (MaterialButton) findViewById(R.id.register_button); //instance of login_button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        String admin_username = "admin"; //temporary username fields, will check database for others
        String admin_password = "admin";

        register_button.setOnClickListener(new View.OnClickListener() { //creates click listener that will check if login_button is clicked
            @Override
            public void onClick(View view) {
                createUser();
                if(username.getText().toString().equals(admin_username) && password.getText().toString().equals(admin_password)) {
                    Toast.makeText(RegisterAcivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show(); //login successful will pop up
                    startActivity(new Intent(RegisterAcivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(RegisterAcivity.this,"LOGIN FAILED", Toast.LENGTH_SHORT).show(); //login failed will pop up
                }
            }
        });

        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterAcivity.this,"LOGIN USER", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterAcivity.this, LoginActivity.class));
            }
        });

    }

    private void createUser(){
        String email = username.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(email)){
            username.setError("Email cannot be empty");
            username.requestFocus();
        }else if(TextUtils.isEmpty(pass)){
            password.setError("Email cannot be empty");
            password.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RegisterAcivity.this,"User Registered Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterAcivity.this, LoginActivity.class));
                                FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterAcivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }
}