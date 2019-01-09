package com.ovrbach.challengeklarna.ui

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.ovrbach.challengeklarna.R
import com.ovrbach.challengeklarna.entity.WeatherResponse
import com.ovrbach.challengeklarna.presenter.MainPresenter

const val REQUEST_PERMISSION_CODE = 2

class MainActivity : Activity(), MainActivityContract {

    override fun onWeatherFetched(weather: WeatherResponse) {
        updateUI(weather)
    }

    override fun onWeatherFetchedFailure(error: Throwable) {
        //todo showErrorMessage()
    }

    companion object {
        val presenter = MainPresenter()
    }

    private val permisssions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    private var lastLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tryAndGetLastLocation()
        getWeather()
    }


    fun tryAndGetLastLocation() {
        if (Build.VERSION.SDK_INT > 23)
            checkPermissions()
        else
            getLastLocation()
    }

    fun getLastLocation() {
        val locationService = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        lastLocation = locationService.getLastKnownLocation(
                LocationManager.GPS_PROVIDER
        )
        getWeather(lastLocation)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun checkPermissions() {
        if (checkSelfPermission(permisssions[0]) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permisssions, REQUEST_PERMISSION_CODE)
            return
        }
        getLastLocation()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_PERMISSION_CODE) {
            val allGranted = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
            if (allGranted) {
                getLastLocation()
            } else {
                Toast.makeText(this, "Permission required", Toast.LENGTH_LONG).show()
                //todo show error on ui rather
            }
        }
    }

    fun getWeather(lastLocation: Location? = null) {
        presenter.getLastWeather(lastLocation?.latitude, lastLocation?.longitude)
    }


    fun updateUI(weather: WeatherResponse) {
        //        main_city_time.text
        //        main_details.text
        //        main_summary.text
    }

}

interface MainActivityContract {
    fun onWeatherFetched(weather: WeatherResponse)
    fun onWeatherFetchedFailure(error: Throwable)
}
