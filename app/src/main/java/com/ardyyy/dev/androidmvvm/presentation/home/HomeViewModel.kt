package com.ardyyy.dev.androidmvvm.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardyyy.dev.androidmvvm.data.models.response.HomeApiResponse
import com.ardyyy.dev.androidmvvm.data.repository.HomeRepository
import com.ardyyy.dev.androidmvvm.utils.EspressoIdlingResource
import com.ardyyy.dev.androidmvvm.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    val homeData = MutableLiveData<UiState<HomeApiResponse>>()

    fun getHomeData() {
        homeData.value = UiState.Loading()

        EspressoIdlingResource.increment()
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                try {
                    val result = homeRepository.getHomeData()
                    homeData.postValue(UiState.Success(result))
                    EspressoIdlingResource.decrement()
                } catch (e: Exception) {
                    homeData.postValue(UiState.Error(e))
                    EspressoIdlingResource.decrement()
                }
            }
        }
    }

}