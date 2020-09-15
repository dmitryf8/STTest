package com.mcoolapp.sttestapp.model

import Datum
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Example {
    @SerializedName("status")
    @Expose
    var status: Status? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}