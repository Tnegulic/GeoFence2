package com.example.toni.geofence2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AddEventActivity extends AppCompatActivity {

    private TextView editId;
    private TextView editRadius;
    private TextView editDuration;
    private TextView editSize;
    private TextView editTime;
    private TextView editSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent addIntent = getIntent();

        TextView editLat = findViewById(R.id.edit_lat);
        TextView editLong = findViewById(R.id.edit_long);
        editId =findViewById(R.id.editId);
        editRadius = findViewById(R.id.editRadius);
        editDuration = findViewById(R.id.editDuration);
        editSize = findViewById(R.id.editSize);
        editTime = findViewById(R.id.editTime);
        editSport = findViewById(R.id.editSport);

        editLong.setText("Long: "+String.valueOf(addIntent.getDoubleExtra("Long",0)));
        editLat.setText("Lat: "+String.valueOf(addIntent.getDoubleExtra("Lat",0)));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //slanje foreme u main activity
                Intent adding = new Intent();
                adding.putExtra("id", editId.getText().toString());
                adding.putExtra("rad", editRadius.getText().toString());
                adding.putExtra("dur", editDuration.getText().toString());
                adding.putExtra("size", editSize.getText().toString());
                adding.putExtra("time", editTime.getText().toString());
                adding.putExtra("sport", editSport.getText().toString());
                setResult(RESULT_OK,adding);
                finish();

                Snackbar.make(view, "Adding Event...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
