package com.example.vikaslandge.exam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        if (intent.getBooleanExtra("from_showall",
                        true)) {
            for (item in list_new2!!) {
                val location = LatLng(item.start_location.lat,
                        item.start_location.lng)
                mMap.addMarker(MarkerOptions().position(location).title(item.start_address))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,
                        17.toFloat()))
                val location2 = LatLng(item.end_location.lat,
                        item.end_location.lng)
                mMap.addMarker(MarkerOptions().position(location).title(item.end_address))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,
                        17.toFloat()))
            }
        } else {
            val sydney = LatLng(intent.getDoubleExtra
            ("latitude", 0.toDouble()),
                    intent.getDoubleExtra
                    ("longitude", 0.toDouble()))
            mMap.addMarker(MarkerOptions().position(sydney).title(intent.getStringExtra("name")))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,
                    17.toFloat()))
        }
    }
}
