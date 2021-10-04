package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

//import android.content.Context;
//import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class Booking extends AppCompatActivity {

   // private Button cart;
   // Button cart;

    RecyclerView recyclerView;
    BookingAdapter bookingAdapter;

    FloatingActionButton floatingActionButton;

    // Button book;
  //  Dialog mDialog; ;

   // FloatingActionButton floatingActionButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).commit();


        //book = (Button)findViewById(R.id.book) ;


        //cart = findViewById(R.id.btnAddcart);
      //  cart.setOnClickListener(new View.OnClickListener() {
      //  @Override
          //public void onClick(View v) {
        //   Intent intent = new Intent(Booking.this,Rooms.class);
        //startActivity(intent);
        //}
        //
        //Add = findViewById(R.id.btnView);
        //context = this;
        //Add = findViewById(R.id.btnView);
        //context = this;
        //Add.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View v) {
        //   startActivity(new Intent(context, BookingActivity.class));
        //}

       // });


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<BookingModel> options =
                new FirebaseRecyclerOptions.Builder<BookingModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("hotels"), BookingModel.class)
                        .build();


        bookingAdapter = new BookingAdapter(options);
        recyclerView.setAdapter(bookingAdapter);


        floatingActionButton= (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddRoomsActivity.class));
            }

        });


        //  floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

      //  floatingActionButton.setOnClickListener(new View.OnClickListener() {
         //   @Override
       //     public void onClick(View v) {
           //     startActivity(new Intent(getApplicationContext(),AddRoomsActivity.class));
            //}
        //});
    }






    @Override
    protected void onStart() {
        super.onStart();
        bookingAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bookingAdapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.booking_search,menu);
        MenuItem item = menu.findItem(R.id.booking_search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str)
    {

        FirebaseRecyclerOptions<BookingModel> options =
                new FirebaseRecyclerOptions.Builder<BookingModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("hotels").orderByChild("tags").startAt(str).endAt(str+"&"), BookingModel.class)
                        .build();

        bookingAdapter = new BookingAdapter(options);
        bookingAdapter.startListening();
        recyclerView.setAdapter(bookingAdapter);
    }
}