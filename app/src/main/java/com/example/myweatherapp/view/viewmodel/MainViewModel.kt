package com.example.myweatherapp.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.model.Weather
import com.example.myweatherapp.repository.WeatherRepository
import kotlinx.coroutines.*

class MainViewModel constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    val weather = MutableLiveData<Weather>()

    init {
        viewModelScope.launch {
            val response = weatherRepository.getWeather()
            withContext(Dispatchers.Main) {
                weather.postValue(weatherRepository.getWeather())
//                if ( response.isSuccessful ){
//                    weather.postValue(response.body())
//                } else {
//                    Log.d("Error", response.message())
//                }
            }
        }
    }
}