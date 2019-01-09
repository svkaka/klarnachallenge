package com.ovrbach.challengeklarna.entity

class WeatherResponse(
        val latitude: Float,
        val longitude: Float,
        val timezone: String,
        val currently: Weather
) {

}

class Weather(
        val time: Long,
        val summary: String,
        val icon: String,
        val precipIntensity: Float,
        val precipProbability: Float,
        val temperature: Float,
        val apparentTemperature: Float,
        val dewPoint: Float,
        val humidity: Float,
        val pressure: Float,
        val windSpeed: Float,
        val windGust: Float,
        val windBearing: Float,
        val cloudCover: Float,
        val uvIndex: Float,
        val visibility: Float,
        val ozone: Float
) {

    override fun toString(): String {
        return "Weather(time=$time, summary='$summary', icon='$icon', precipIntensity=$precipIntensity, precipProbability=$precipProbability, temperature=$temperature, apparentTemperature=$apparentTemperature, dewPoint=$dewPoint, humidity=$humidity, pressure=$pressure, windSpeed=$windSpeed, windGust=$windGust, windBearing=$windBearing, cloudCover=$cloudCover, uvIndex=$uvIndex, visibility=$visibility, ozone=$ozone)"
    }

    fun getDetailsString(): String {
        return "precipIntensity=$precipIntensity\nprecipProbability=$precipProbability\ntemperature=$temperature\napparentTemperature=$apparentTemperature\ndewPoint=$dewPoint\nhumidity=$humidity\npressure=$pressure\nwindSpeed=$windSpeed\nwindGust=$windGust\nwindBearing=$windBearing\ncloudCover=$cloudCover\nuvIndex=$uvIndex\nvisibility=$visibility\nozone=$ozone)"
    }
}
