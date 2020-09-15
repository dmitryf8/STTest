package com.mcoolapp.sttestapp.repository

import com.mcoolapp.sttestapp.interfaces.ApiService

class ApiHelper(private val apiService: ApiService) {

    suspend fun getCurrencyList() = apiService.getCurrencyList("c157009e-fab9-4728-92ab-b6b07b5e665d")
    suspend fun getMetadata(list: List<String>) = apiService.getMetadata("c157009e-fab9-4728-92ab-b6b07b5e665d", list.joinToString(","))
}