package com.app.social_m.retrofitUtils

import com.app.social_m.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun fetchUsers() :Call<List<Users>>

}