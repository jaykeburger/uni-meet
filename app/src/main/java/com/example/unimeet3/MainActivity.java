package com.example.unimeet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_activity_main);
        final EditText edit_name = findViewById(R.id.bruh);
        final EditText edit_position = findViewById(R.id.bruh);
        Button button = findViewById(R.id.bruh);

        DAOProfileFeed dao = new DAOProfileFeed();
        button.setOnClickListener( v-> {

            String[] x = new String[6];
            String[] y = new String[6];
            String[] z = new String[6];

            ProfileFeed profileFeed = new ProfileFeed(edit_name.getText().toString(), edit_position.getText().toString(), "", "","", "", x, y, z);

            dao.add(profileFeed).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}