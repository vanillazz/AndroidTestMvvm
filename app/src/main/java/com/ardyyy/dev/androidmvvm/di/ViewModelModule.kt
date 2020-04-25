package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel( get()) }
}