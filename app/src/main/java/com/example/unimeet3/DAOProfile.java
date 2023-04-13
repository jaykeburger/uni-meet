package com.example.unimeet3;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOProfile {

    private DatabaseReference databaseReference;

    public DAOProfile() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Profile.class.getSimpleName());

    }

    public Task<Void> add(Profile profile) {
        return databaseReference.push().setValue(profile);
    }
}
