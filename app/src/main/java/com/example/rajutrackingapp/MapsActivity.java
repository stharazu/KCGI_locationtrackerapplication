package com.example.rajutrackingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.rajutrackingapp.rajutrackingapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near KCGI
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in KCGI and move the camera
        LatLng kcgi = new LatLng(35.030686, 135.779302);
        MarkerOptions marker = new MarkerOptions().position(kcgi).title("The Kyoto College of Graduate for Informatics");
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.userplaceholder));
        mMap.addMarker(marker);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(kcgi));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));


        //zoom into a particular position
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
        mMap.moveCamera(zoom);
        mMap.animateCamera(zoom);
    }
}
