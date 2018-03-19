package com.example.toni.geofence2;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;


public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Event addEvent(final AppDatabase db, Event event) {
        db.eventDao().insertAll(event);
        return event;
    }

    private static void populateWithTestData(AppDatabase db) {
        Event event = new Event();
        event.setId("Rukomettt");
        event.setRadius(500.0f);
        event.setSize(25);
        event.setGooing(0);
        event.setTime("15:30");
        event.setSport("rukomet");
        event.setDuration(60);
        event.setOwner("Toni");
        event.setLat(45.4003);
        event.setLng(14.4326);

        //addEvent(db, event);


        List<Event> eventList = db.eventDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + eventList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
