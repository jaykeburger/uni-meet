package com.example.unimeet3;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOProfileFeed {

    private DatabaseReference databaseReference;

    public DAOProfileFeed() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(ProfileFeed.class.getSimpleName());

    }

    public Task<Void> add(ProfileFeed profileFeed) {
        return databaseReference.push().setValue(profileFeed);
    }
}
