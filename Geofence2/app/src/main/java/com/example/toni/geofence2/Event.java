package com.example.toni.geofence2;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Toni on 10.03.2018..
 */

public class Event {

    private String mId;       //Naslov

    private LatLng mLatLng;
    private float mRadius;
    private long mDuration; //trajanje geofencea

    private int mNumId;        // br eventa

    private int mSize;      //max broj mjesta
    private int mGooing;    //br dolazaka
    private String mSport;
    private String mOwner;
    private String mTime; //vrijeme eventa


    public Event(LatLng latLng, String s) { //trenutacni constructor
        mLatLng = latLng;
        mId = s;
    }

    public Event(String mId, LatLng mLatLng, float mRadius, long mDuration, int mNumId, int mSize, int mGooing, String mSport, String mOwner, String mTime) {
        this.mId = mId;
        this.mLatLng = mLatLng;
        this.mRadius = mRadius;
        this.mDuration = mDuration;
        this.mNumId = mNumId;
        this.mSize = mSize;
        this.mGooing = mGooing;
        this.mSport = mSport;
        this.mOwner = mOwner;
        this.mTime = mTime;
    }

    void StoreEvent(LatLng latlng, String id) { //potencijala funkcija za update eventa u bazi
        mLatLng = latlng;
        mId = id;
    }

    public String getmId() {
        return mId;
    }

    public LatLng getmLatLng() {
        return mLatLng;
    }

    public float getmRadius() {
        return mRadius;
    }

    public long getmDuration() {
        return mDuration;
    }

    public int getmNumId() {
        return mNumId;
    }

    public int getmSize() {
        return mSize;
    }

    public String getmSport() {
        return mSport;
    }

    public String getmOwner() {
        return mOwner;
    }

    public int getmGooing() {
        return mGooing;
    }

    public String getmTime() {
        return mTime;
    }
}
