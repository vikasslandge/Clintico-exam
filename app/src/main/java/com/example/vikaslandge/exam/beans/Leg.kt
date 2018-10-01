package com.example.vikaslandge.exam.beans

data class Leg(
        val distance: DistanceX,
        val duration: DurationX,
        val end_address: String,
        val end_location: EndLocation,
        val start_address: String,
        val start_location: StartLocation,
        val steps: List<Step>,
        val traffic_speed_entry: List<Any>,
        val via_waypoint: List<Any>
)