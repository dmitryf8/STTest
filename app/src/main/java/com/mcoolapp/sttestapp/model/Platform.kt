package com.mcoolapp.sttestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Platform {
    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("token_address")
    @Expose
    var tokenAddress: String? = null

}
