package com.example.draggerapppp.domain.weather

import java.time.LocalDateTime

data class WeatherData (
    val time:LocalDateTime,
    val temperatureCelsius:Double,
    val pressure:Double,
    val windSpeed:Double,
    val humidity:Double,
    val weatherType: WeatherType

        )
