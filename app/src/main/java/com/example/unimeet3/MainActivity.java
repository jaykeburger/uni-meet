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

        DAOProfile dao = new DAOProfile();
        update_button.setOnClickListener( v-> {

            String[] orgs = new String[6];
            String[] classes = new String[6];
            String[] hobbies = new String[6];

            orgs[0] = org1.getText().toString();
            orgs[1] = org2.getText().toString();
            orgs[2] = org3.getText().toString();

            classes[0] = class1.getText().toString();
            classes[1] = class2.getText().toString();
            classes[2] = class3.getText().toString();
            classes[3] = class4.getText().toString();
            classes[4] = class5.getText().toString();
            classes[5] = class6.getText().toString();

            hobbies[0] = hobby1.getText().toString();
            hobbies[1] = hobby2.getText().toString();
            hobbies[2] = hobby3.getText().toString();
            hobbies[3] = hobby4.getText().toString();
            hobbies[4] = hobby5.getText().toString();
            hobbies[5] = hobby6.getText().toString();

            Profile profile = new Profile(name.getText().toString(), age.getText().toString(), "","", "", classes, hobbies, orgs);

            dao.add(profile).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}