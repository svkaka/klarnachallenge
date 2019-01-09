package com.ovrbach.challengeklarna.cases

import android.os.AsyncTask
import com.ovrbach.challengeklarna.entity.LatLong
import com.ovrbach.challengeklarna.entity.Response
import com.ovrbach.challengeklarna.entity.WeatherResponse
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

const val BASE_URL = "https://api.darksky.net/forecast/2bb07c3bece89caf533ac9a5d23d8417/"

class FetchWeatherAsync(val callback: ResultCallback<WeatherResponse>) : AsyncTask<LatLong, Void, WeatherResponse>() {

    override fun doInBackground(vararg params: LatLong): WeatherResponse {
        val location = params[0]

        val url = URL("$BASE_URL${location.lat},${location.long}")
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            val response = readStream(reader)
            reader.close()

            return WeatherResponse(JSONObject(response))
        } finally {
            urlConnection.disconnect()
        }
    }

    private fun readStream(reader: BufferedReader): String {
        val builder = StringBuilder()
        reader.forEachLine {
            builder.append(it)
        }
        return builder.toString()
    }

    override fun onPostExecute(result: WeatherResponse?) {
        super.onPostExecute(result)
        if (result != null)
            callback.onFinished(Response.Success(result))
    }
}

