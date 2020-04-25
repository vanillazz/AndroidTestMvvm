package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.data.repository.HomeRepository
import org.koin.dsl.module

val dataModule = module {
    single { HomeRepository(get()) }
}