package com.example.vikaslandge.exam

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext

import com.google.android.gms.maps.model.PolylineOptions





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
                        6.toFloat()))
                val location2 = LatLng(item.end_location.lat,
                        item.end_location.lng)
                mMap.addMarker(MarkerOptions().position(location2).title(item.end_address))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location2,
                        6.toFloat()))
                val location3 = LatLng(lati!!, longi!!)
                mMap.addMarker(MarkerOptions().position(location3).title("current location"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location3,
                        6.toFloat()))
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

      var  context = GeoApiContext.Builder().apiKey("AIzaSyAd2Yj_O5GZhsfWzB8H4w1UvC-fWBggItg").build()
        var dir = DirectionsApi.getDirections(context,"list_new2!![0].start_location.lat.toString(),list_new2!![0].start_location.lng .toString()", "list_new2!![0].end_location.lat.toString(), list_new2!![0].end_location.lng .toString()")
        var line  = PolylineOptions().color((Color.BLUE))
                .add(LatLng(list_new2!![0].start_location.lat,list_new2!![0].start_location.lng))
                .add( LatLng(lati!!,longi!!));

        var polyline = mMap.addPolyline(line);
        var line2  = PolylineOptions().color(Color.RED)
                .add( LatLng(lati!!,longi!!))
                .add(LatLng(list_new2!![0].end_location.lat,list_new2!![0].end_location.lng))

        var polyline2 = mMap.addPolyline(line2)



    }
}
