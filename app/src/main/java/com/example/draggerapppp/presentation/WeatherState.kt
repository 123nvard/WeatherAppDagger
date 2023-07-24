package com.example.draggerapppp.presentation

import com.example.draggerapppp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo:WeatherInfo?=null,
    val isLoading:Boolean=false,
    val error:String? =null
)
