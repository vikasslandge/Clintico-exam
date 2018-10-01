package com.example.vikaslandge.exam

import android.telecom.Call
import android.webkit.WebStorage
import com.example.vikaslandge.exam.beans.distanceApi
import retrofit2.http.GET
import retrofit2.http.Query

interface DistanceApi {
    @GET("maps/api/distancematrix/json?units=imperial&key=AIzaSyAd2Yj_O5GZhsfWzB8H4w1UvC-fWBggItg")
    fun getDistanceAPI(@Query ("origins")org : String,@Query ("destinations")dest:String):retrofit2.Call<distanceApi>
}