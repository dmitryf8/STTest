package com.mcoolapp.sttestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class USD {
    @SerializedName("price")
    @Expose
    private val price = 0.0

    @SerializedName("volume_24h")
    @Expose
    private val volume24h = 0.0

    @SerializedName("percent_change_1h")
    @Expose
    private val percentChange1h = 0.0

    @SerializedName("percent_change_24h")
    @Expose
    private val percentChange24h = 0.0

    @SerializedName("percent_change_7d")
    @Expose
    private val percentChange7d = 0.0

    @SerializedName("market_cap")
    @Expose
    private val marketCap = 0.0

    @SerializedName("last_updated")
    @Expose
    private val lastUpdated: String? = null

    fun getPrice(): Double {
        return price
    }
}