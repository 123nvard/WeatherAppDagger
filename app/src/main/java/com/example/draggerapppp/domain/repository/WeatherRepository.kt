package com.example.draggerapppp.domain.repository

import com.example.draggerapppp.domain.util.Resource
import com.example.draggerapppp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,ling:Double):Resource<WeatherInfo>

}