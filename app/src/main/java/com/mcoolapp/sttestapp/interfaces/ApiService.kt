package com.mcoolapp.sttestapp.interfaces

import com.mcoolapp.sttestapp.model.Example
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers(
        "Accept: application/json",
        "User-Agent: Retrofit-Sample-App"
    )
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getCurrencyList(
        @Query("CMC_PRO_API_KEY")
        key: String): Example

    @GET("/v1/cryptocurrency/info")
    suspend fun getMetadata(
        @Query("CMC_PRO_API_KEY")
        key: String,
        @Query("id")
        id:String): JSONObject
}