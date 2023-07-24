package com.example.draggerapppp.data.repository

import com.example.draggerapppp.data.mappers.toWeatherInfo
import com.example.draggerapppp.data.remote.WeatherApi
import com.example.draggerapppp.domain.repository.WeatherRepository
import com.example.draggerapppp.domain.util.Resource
import com.example.draggerapppp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api:WeatherApi
):WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
     return try {
         Resource.Success(
             data=api.getWeatherData(
                 lat,long
             ).toWeatherInfo()
         )
     }catch (e:Exception){
         e.printStackTrace()
         Resource.Error(e.message?:"Unknown error")
     }
    }
}