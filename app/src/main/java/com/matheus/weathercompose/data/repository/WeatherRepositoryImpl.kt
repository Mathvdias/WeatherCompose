package com.matheus.weathercompose.data.repository

import com.matheus.weathercompose.data.mappers.toWeatherInfo
import com.matheus.weathercompose.data.remote.WeatherApi
import com.matheus.weathercompose.domain.repository.WeatherRepository
import com.matheus.weathercompose.domain.util.Resource
import com.matheus.weathercompose.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherDAta(
                    lat = lat,
                    long = long,
                ).toWeatherInfo()
            )
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occured.")
        }
    }
}