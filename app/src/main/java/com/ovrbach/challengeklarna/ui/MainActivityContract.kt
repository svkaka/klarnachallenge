package com.ovrbach.challengeklarna.ui

import com.ovrbach.challengeklarna.entity.WeatherResponse

interface MainActivityContract {
    fun onWeatherFetched(weather: WeatherResponse)
    fun onWeatherFetchedFailure(error: Throwable)
}