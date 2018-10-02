package com.example.vikaslandge.exam

 import com.example.vikaslandge.exam.beans.PlacesAPIBeans
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesAPI {
    @GET("maps/api/directions/json?&key=AIzaSyAd2Yj_O5GZhsfWzB8H4w1UvC-fWBggItg")
    fun getPlacesAPIBeans(@Query("origin") loc: String,
                          @Query("destination") type: String): Call<PlacesAPIBeans>
}