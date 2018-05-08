package com.example.toni.geofence2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ArrayList<Event> events = new ArrayList<Event>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //dohvacanje intenta
        final Intent detailsIntent = getIntent();

        //spajanje na bazu TESTNO
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("events");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                LinearLayout linearLayout= findViewById(R.id.LLDetails);
                TextView textView;
                TextView textView1;
                TextView textView2;
                TextView textView3;
                TextView textView4;


                for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                    try {
                        //Ako stavimo da je obavezno polje nece imati mogućnost generiranja NULL
                        events.add(new Event(snapshot.getValue(Event.class).getId(),
                                new LatLng(snapshot.getValue(Event.class).getLat(),snapshot.getValue(Event.class).getLng()),
                                snapshot.getValue(Event.class).getRadius(),
                                snapshot.getValue(Event.class).getDuration(),
                                snapshot.getValue(Event.class).getNumId(),
                                snapshot.getValue(Event.class).getSize(),
                                snapshot.getValue(Event.class).getGooing(),
                                snapshot.getValue(Event.class).getSport(),
                                snapshot.getValue(Event.class).getOwner(),
                                snapshot.getValue(Event.class).getTime()));
                    } catch (Exception e) {
                        Log.d("Fail: ", "Problem!");
                    }
                }

                for (Event event : events){
                    if((detailsIntent.getDoubleExtra("Lat",0) == event.getLat()) && (detailsIntent.getDoubleExtra("Lng",0) == event.getLng())) {
                        textView = new TextView(getApplicationContext());
                        textView.setText(event.getId());
                        textView1 = new TextView(getApplicationContext());
                        textView1.setText(event.getGooing() + "/" + event.getSize() );
                        textView2 = new TextView(getApplicationContext());
                        textView2.setText(event.getOwner());
                        textView3 = new TextView(getApplicationContext());
                        textView3.setText(event.getSport());
                        textView4 = new TextView(getApplicationContext());
                        textView4.setText(event.getTime());
                        linearLayout.addView(textView);
                        linearLayout.addView(textView1);
                        linearLayout.addView(textView2);
                        linearLayout.addView(textView3);
                        linearLayout.addView(textView4);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
