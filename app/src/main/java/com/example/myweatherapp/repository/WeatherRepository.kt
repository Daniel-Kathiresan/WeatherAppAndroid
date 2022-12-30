package com.example.myweatherapp.repository

import com.example.myweatherapp.network.ApiInterface

class WeatherRepository(private val apiInterface: ApiInterface,) {
    suspend fun getWeather() = apiInterface.getWeather(lay = 44.3f, lon = 10.99f, apiKey =  "" /*todo: replace this*/
)
}