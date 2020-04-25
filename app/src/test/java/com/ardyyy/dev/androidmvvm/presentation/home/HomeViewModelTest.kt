package com.ardyyy.dev.androidmvvm.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ardyyy.dev.androidmvvm.data.repository.HomeRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock


class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel
    private val homeRepository = mock(HomeRepository::class.java)

    @Before
    fun before() {
        homeViewModel = HomeViewModel(homeRepository)
    }

    @Test
    fun getHomeData() {
        homeViewModel.getHomeData()
        Assert.assertNotNull(homeViewModel.homeData.value)
    }
}