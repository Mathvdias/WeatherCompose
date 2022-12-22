package com.matheus.weathercompose.domain.repository

import com.matheus.weathercompose.domain.util.Resource
import com.matheus.weathercompose.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}