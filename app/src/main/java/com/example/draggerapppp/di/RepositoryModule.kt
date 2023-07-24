package com.example.draggerapppp.di

import com.example.draggerapppp.data.location.DefaultLocationTracker
import com.example.draggerapppp.data.repository.WeatherRepositoryImpl
import com.example.draggerapppp.domain.location.LocationTracker
import com.example.draggerapppp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
       weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

}