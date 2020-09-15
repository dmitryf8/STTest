package com.mcoolapp.sttestapp.repository

import com.mcoolapp.sttestapp.interfaces.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.reflect.KClass

class RetrofitBuilder {

    private val BASE_URL = "https://pro-api.coinmarketcap.com"



    private fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build();
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter

        println(" URL " + retrofitBuilder.baseUrl())

        return retrofitBuilder
    }

    val apiService: ApiService = getRetrofit()
        .create(ApiService::class.java)
}


