package com.example.myweatherapp.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder().addQueryParameter("APPID","690459975691b2802e04ad143c7ff8e4").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}