package com.example.bingdaily.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private val BASE_URL = "https://cn.bing.com/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    inline fun <reified T> create() : T{
        return create<T>(T::class.java)
    }
}