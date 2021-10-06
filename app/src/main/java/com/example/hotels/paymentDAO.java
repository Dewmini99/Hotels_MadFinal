package com.example.hotels;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class paymentDAO {
    private DatabaseReference databaseReference;
    public paymentDAO()
    {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(paymenthandle.class.getSimpleName());
    }

    public Task<Void> add(paymenthandle payments)
    {
        return databaseReference.push().setValue(payments);
    }
}
