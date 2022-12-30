package com.example.myweatherapp.network

import com.example.myweatherapp.`object`.Constants
import com.example.myweatherapp.model.Weather
import com.example.myweatherapp.network.ApiInterface.Companion.apiInterface
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather?units=metric&")
    suspend fun getWeather(@Query("lat") lay: Float,
                           @Query("lon") lon: Float,
                           @Query("APPID") apiKey: String): Weather

    companion object{
        var apiInterface: ApiInterface? = null
        fun getInstance() : ApiInterface {
            val authInterceptor = AuthInterceptor()
            if (apiInterface == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                apiInterface = retrofit.create(ApiInterface::class.java)
            }
            return apiInterface!!
        }
    }
}