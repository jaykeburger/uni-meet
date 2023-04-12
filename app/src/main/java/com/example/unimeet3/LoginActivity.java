//package com.example.unimeet3;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.button.MaterialButton;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private FirebaseAuth mAuth;
//
//    TextView username = (TextView) findViewById(R.id.email); //instance of textview
//    TextView password = (TextView) findViewById(R.id.password); //instance of password
//    TextView new_user = (TextView) findViewById(R.id.newuser); //instance of newuser
//    TextView forgot_password = (TextView) findViewById(R.id.forgotpassword); //instance of forgotpassword
//
//    MaterialButton login_button = (MaterialButton) findViewById(R.id.login_button); //instance of login_button
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        String admin_username = "admin"; //temporary username fields, will check database for others
//        String admin_password = "admin";
//
//        login_button.setOnClickListener(new View.OnClickListener() { //creates click listener that will check if login_button is clicked
//            @Override
//            public void onClick(View view) {
//                loginUser();
//                if(username.getText().toString().equals(admin_username) && password.getText().toString().equals(admin_password)) {
//                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show(); //login successful will pop up
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                }
//                else {
//                    Toast.makeText(LoginActivity.this,"LOGIN FAILED", Toast.LENGTH_SHORT).show(); //login failed will pop up
//                }
//            }
//        });
//
//        new_user.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this,"CREATE ACCOUNT", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this, RegisterAcivity.class));
//            }
//        });
//
//        forgot_password.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this,"FORGOT PASSWORD", Toast.LENGTH_SHORT).show();
//                //TODO: REDIRECT TO FORGOT PASSWORD PAGE
//            }
//        });
//
//    }
//
//    private void loginUser(){
//        String email = username.getText().toString();
//        String pass = password.getText().toString();
//
//        if(TextUtils.isEmpty(email)){
//            username.setError("Email cannot be empty");
//            username.requestFocus();
//        }else if(TextUtils.isEmpty(pass)){
//            password.setError("Email cannot be empty");
//            password.requestFocus();
//        }else{
//            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                Toast.makeText(LoginActivity.this,"SignIn Success",Toast.LENGTH_SHORT).show();
//                                FirebaseUser user = mAuth.getCurrentUser();
//                            } else {
//                                Toast.makeText(LoginActivity.this,"SignIn Error",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }
//
//    }
//}