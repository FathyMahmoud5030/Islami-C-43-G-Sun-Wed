package com.route.islamic43gsunwed.fragments.quran.model

import com.google.gson.annotations.SerializedName

data class RadioResponse(
    @field:SerializedName("radios")
    val radios: List<RadiosItem?>? = null
)

data class RadiosItem(
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("url")
    val url: String? = null
)