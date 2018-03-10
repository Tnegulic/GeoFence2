package com.example.toni.geofence2;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Toni on 10.03.2018..
 */

public class Event {

    public LatLng mLatLng;
    public String mId;

    public Event(LatLng latLng, String s) {
        mLatLng = latLng;
        mId = s;
    }

    void StoreEvent(LatLng latlng, String id) {
        mLatLng = latlng;
        mId = id;
    }
}
