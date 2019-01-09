package com.ovrbach.challengeklarna.entity

import org.json.JSONObject

class WeatherResponse {
    val latitude: Double
    val longitude: Double
    val timezone: String
    val currently: Weather

    constructor(
            json: JSONObject
    ) {
        latitude = json.get("latitude") as Double
        longitude = json.get("longitude") as Double
        timezone = json.get("timezone") as String
        currently = Weather(json.getJSONObject("currently"))
    }

}

class Weather {
    val time: Int
    val summary: String
    val icon: String
    val precipIntensity: Double
    val precipProbability: Double
    val temperature: Double
    val apparentTemperature: Double
    val dewPoint: Double
    val humidity: Double
    val pressure: Double
    val windSpeed: Double
    val windGust: Double
    val windBearing: Int
    val cloudCover: Double
    val uvIndex: Int
    val visibility: Double
    val ozone: Double

    constructor(jsonObject: JSONObject) {
        time = jsonObject.get("time") as Int
        summary = jsonObject.get("summary") as String
        icon = jsonObject.get("icon") as String
        precipIntensity = jsonObject.get("precipIntensity") as Double
        precipProbability = jsonObject.get("precipProbability") as Double
        temperature = jsonObject.get("temperature") as Double
        apparentTemperature = jsonObject.get("apparentTemperature") as Double
        dewPoint = jsonObject.get("dewPoint") as Double
        humidity = jsonObject.get("humidity") as Double
        pressure = jsonObject.get("pressure") as Double
        windSpeed = jsonObject.get("windSpeed") as Double
        windGust = jsonObject.get("windGust") as Double
        windBearing = jsonObject.get("windBearing") as Int
        cloudCover = jsonObject.get("cloudCover") as Double
        uvIndex = jsonObject.get("uvIndex") as Int
        visibility = jsonObject.get("visibility") as Double
        ozone = jsonObject.get("ozone") as Double
    }

    override fun toString(): String {
        return "Weather(time=$time, summary='$summary', icon='$icon', precipIntensity=$precipIntensity, precipProbability=$precipProbability, temperature=$temperature, apparentTemperature=$apparentTemperature, dewPoint=$dewPoint, humidity=$humidity, pressure=$pressure, windSpeed=$windSpeed, windGust=$windGust, windBearing=$windBearing, cloudCover=$cloudCover, uvIndex=$uvIndex, visibility=$visibility, ozone=$ozone)"
    }

    fun getDetailsString(): String {
        return "precipIntensity=$precipIntensity\nprecipProbability=$precipProbability\ntemperature=$temperature\napparentTemperature=$apparentTemperature\ndewPoint=$dewPoint\nhumidity=$humidity\npressure=$pressure\nwindSpeed=$windSpeed\nwindGust=$windGust\nwindBearing=$windBearing\ncloudCover=$cloudCover\nuvIndex=$uvIndex\nvisibility=$visibility\nozone=$ozone)"
    }
}
