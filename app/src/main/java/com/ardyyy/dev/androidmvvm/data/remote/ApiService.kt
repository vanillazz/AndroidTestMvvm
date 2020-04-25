package com.ardyyy.dev.androidmvvm.data.remote

import com.ardyyy.dev.androidmvvm.data.models.response.HomeApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("home")
    suspend fun getHomeData(): HomeApiResponse
}