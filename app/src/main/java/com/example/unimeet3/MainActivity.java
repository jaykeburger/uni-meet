package com.example.unimeet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup);
        final EditText name = findViewById(R.id.name);
        final EditText age = findViewById(R.id.age);
        final EditText pic = findViewById(R.id.pic);
        final EditText major = findViewById(R.id.major);
        final EditText minor = findViewById(R.id.minor);
        final EditText bio = findViewById(R.id.bio);
        final EditText org1 = findViewById(R.id.org1);
        final EditText org2 = findViewById(R.id.org2);
        final EditText org3 = findViewById(R.id.org3);
        final EditText class1 = findViewById(R.id.class1);
        final EditText class2 = findViewById(R.id.class2);
        final EditText class3 = findViewById(R.id.class3);
        final EditText class4 = findViewById(R.id.class4);
        final EditText class5 = findViewById(R.id.class5);
        final EditText class6 = findViewById(R.id.class6);
        final EditText hobby1 = findViewById(R.id.hobby1);
        final EditText hobby2 = findViewById(R.id.hobby2);
        final EditText hobby3 = findViewById(R.id.hobby3);
        final EditText hobby4 = findViewById(R.id.hobby4);
        final EditText hobby5 = findViewById(R.id.hobby5);
        final EditText hobby6 = findViewById(R.id.hobby6);
        Button update_button = findViewById(R.id.upload_button);

        DAOProfileFeed dao = new DAOProfileFeed();
        update_button.setOnClickListener( v-> {

            String[] x = new String[6];
            String[] y = new String[6];
            String[] z = new String[6];

            ProfileFeed profileFeed = new ProfileFeed(name.getText().toString(), age.getText().toString(), "", "","", "", x, y, z);

            dao.add(profileFeed).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}