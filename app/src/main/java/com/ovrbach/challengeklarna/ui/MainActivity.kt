package com.ovrbach.challengeklarna.ui

import android.app.Activity
import android.os.Bundle
import com.ovrbach.challengeklarna.R
import com.ovrbach.challengeklarna.entity.Weather
import com.ovrbach.challengeklarna.entity.WeatherResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun updateUI(weather: WeatherResponse) {
//        main_city_time.text
//        main_details.text
//        main_summary.text
    }

}
