package com.example.toni.geofence2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
    public interface EventDao {

    @Query("SELECT * FROM event")
    List<Event> getAll();

    @Query("SELECT * FROM event where mId LIKE  :mId ")
    Event findByName(String mId);

    @Query("SELECT COUNT(*) from event")
    int countEvents();

    @Insert
    void insertAll(Event... events);

    @Delete
    void delete(Event event);
}
