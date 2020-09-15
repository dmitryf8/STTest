package com.mcoolapp.sttestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Quote {
    @SerializedName("USD")
    @Expose
    var uSD: USD? = null

}