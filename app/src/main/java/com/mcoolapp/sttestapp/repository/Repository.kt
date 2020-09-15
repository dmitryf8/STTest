package com.mcoolapp.sttestapp.repository

import retrofit2.http.GET

class Repository(private val apiHelper: ApiHelper) {

    suspend fun getCurrencyList() = apiHelper.getCurrencyList()
    suspend fun getMetadata(list: List<String>) = apiHelper.getMetadata(list)
}