package com.app.social_m.retrofitUtils

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

object RetrofitService {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val TAG = "RetrofitServiceClass"

    private val httpLogger :HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val httpClientBuilder :OkHttpClient.Builder by lazy {
        Log.d(TAG, "HttpLoggerBuilder : ${httpLogger.hashCode()}")
        OkHttpClient.Builder()
                .addInterceptor(httpLogger)
    }

    private val retrofit :Retrofit by lazy {
        Log.d(TAG, "HttpClientBuilder: ${httpClientBuilder.build().hashCode()}")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService :ApiService by lazy {
        Log.d(TAG, "retrofit : ${retrofit.hashCode()}")
        retrofit.create(ApiService::class.java)
    }
}