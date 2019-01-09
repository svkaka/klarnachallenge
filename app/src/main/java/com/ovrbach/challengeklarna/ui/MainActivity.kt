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
import com.ovrbach.challengeklarna.entity.Weather
import com.ovrbach.challengeklarna.entity.WeatherResponse
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_PERMISSION_CODE = 2

class MainActivity : Activity() {

    private val permisssions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    private lateinit var lastLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tryAndGetLastLocation()
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
        println("lastlocation: $lastLocation")
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


    fun updateUI(weather: WeatherResponse) {
        //        main_city_time.text
        //        main_details.text
        //        main_summary.text
    }

}
