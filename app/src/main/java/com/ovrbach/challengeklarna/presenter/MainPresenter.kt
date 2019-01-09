package com.ovrbach.challengeklarna.presenter

import com.ovrbach.challengeklarna.entity.WeatherResponse
import com.ovrbach.challengeklarna.ui.MainActivityContract

class MainPresenter {
    var actityContract: MainActivityContract? = null
    private var lastWeather: WeatherResponse? = null

    fun getLastWeather(lat: Double?, lon: Double?) {

        lastWeather?.let {
            handleResult(it)
            return
        }
        if (lat == null || lon == null){
            fetchWeather(lat, lon)
        }
    }

    fun fetchWeather(lat: Double?, lon: Double?) {


    }

    fun handleResult(weatherResponse: WeatherResponse) {

    }
}