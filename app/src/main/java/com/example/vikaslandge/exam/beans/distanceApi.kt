package com.example.vikaslandge.exam.beans

data class distanceApi(
        val destination_addresses: List<String>,
        val origin_addresses: List<String>,
        val rows: List<Row>,
        val status: String
)