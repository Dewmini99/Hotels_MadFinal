package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRooms extends AppCompatActivity {

    Button addfeedback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addfeedback = (Button) findViewById(R.id.addfeedback);
        addfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentLoadNewActivity = new Intent(SelectRooms.this, Feedback.class);
               // startActivity(intentLoadNewActivity);
            }
        });


    }
}