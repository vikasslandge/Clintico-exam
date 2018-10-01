package com.example.vikaslandge.exam.beans

data class GeocodedWaypoint(
        val geocoder_status: String,
        val place_id: String,
        val types: List<String>
)