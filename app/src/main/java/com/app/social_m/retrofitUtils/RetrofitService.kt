package com.app.social_m.retrofitUtils

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val TAG = "RetrofitServiceClass"

    /*private val httpClientBuilder :OkHttpClient.Builder by lazy {
        OkHttpClient.Builder()
    }

    private val httpLogger :HttpLoggingInterceptor by lazy {
        Log.d(TAG, "HttpClientBuilder hashcode: ${httpClientBuilder.hashCode()}")
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addNetworkInterceptor(this)
            httpClientBuilder.build()
        }
    }*/



   /* private val retrofit :Retrofit by lazy {
       // Log.d(TAG, "HttpLoggingInterceptor: ${httpLogger.hashCode()}")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client()
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }*/
}