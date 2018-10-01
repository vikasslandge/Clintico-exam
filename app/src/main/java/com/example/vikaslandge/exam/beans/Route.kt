package com.example.vikaslandge.exam.beans

data class Route(
        val bounds: Bounds,
        val copyrights: String,
        val legs: List<Leg>,
        val overview_polyline: OverviewPolyline,
        val summary: String,
        val warnings: List<Any>,
        val waypoint_order: List<Any>
)