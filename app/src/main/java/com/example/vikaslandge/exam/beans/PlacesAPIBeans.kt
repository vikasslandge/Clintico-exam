package com.example.vikaslandge.exam.beans

data class PlacesAPIBeans(
        val geocoded_waypoints: List<GeocodedWaypoint>,
        val routes: List<Route>,
        val status: String
)