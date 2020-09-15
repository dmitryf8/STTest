package com.mcoolapp.sttestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Status {
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null

    @SerializedName("error_code")
    @Expose
    var errorCode: Long = 0

    @SerializedName("error_message")
    @Expose
    var errorMessage: String? = null

    @SerializedName("elapsed")
    @Expose
    var elapsed: Long = 0

    @SerializedName("credit_count")
    @Expose
    var creditCount: Long = 0

    @SerializedName("notice")
    @Expose
    var notice: String? = null

    @SerializedName("total_count")
    @Expose
    var totalCount: Long = 0

}