package com.ardyyy.dev.androidmvvm.data.repository

import com.ardyyy.dev.androidmvvm.data.remote.ApiService

class HomeRepository(private val apiService: ApiService) {

    suspend fun getHomeData() =
        apiService.getHomeData()

}