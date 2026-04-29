package com.route.islamic43gsunwed.api

import com.route.islamic43gsunwed.fragments.quran.model.RadioResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("v3/radios")
    fun getRadios(@Query("language") lang: String = "ar"): Call<RadioResponse>
}