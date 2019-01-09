package com.ovrbach.challengeklarna.presenter

import com.ovrbach.challengeklarna.cases.FetchWeatherAsync
import com.ovrbach.challengeklarna.cases.ResultCallback
import com.ovrbach.challengeklarna.entity.LatLong
import com.ovrbach.challengeklarna.entity.Response
import com.ovrbach.challengeklarna.entity.WeatherResponse
import com.ovrbach.challengeklarna.ui.MainActivityContract

class MainPresenter {
    var actityContract: MainActivityContract? = null
    private var lastWeather: Response<WeatherResponse>? = null

    fun getLastWeather(lat: Double?, lon: Double?) {

        lastWeather?.let {
            handleResult(it)
            return
        }
        if (lat != null && lon != null) {
            fetchWeather(lat, lon)
        }
    }

    fun fetchWeather(lat: Double, lon: Double) {

        FetchWeatherAsync(object : ResultCallback<WeatherResponse> {
            override fun onFinished(result: Response<WeatherResponse>) {
                handleResult(result)
            }
        }).execute(LatLong(lat, lon))

    }

    fun handleResult(weatherResponse: Response<WeatherResponse>) {
        lastWeather=weatherResponse
        println("$lastWeather < RESPONSE")
        when (weatherResponse) {
            is Response.Success -> actityContract?.onWeatherFetched(weatherResponse.data)
            is Response.Error -> actityContract?.onWeatherFetchedFailure(weatherResponse.error)
            is Response.Cancelled -> actityContract?.onWeatherFetchedFailure(Exception("fetch was cancelled"))
        }
    }
}