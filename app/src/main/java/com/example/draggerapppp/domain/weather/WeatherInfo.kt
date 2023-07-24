package com.example.draggerapppp.domain.weather


data class WeatherInfo(
    val weatherDataPerDay:Map<Int,List<WeatherData>>,
    val currentWeatherData:WeatherData?
)
