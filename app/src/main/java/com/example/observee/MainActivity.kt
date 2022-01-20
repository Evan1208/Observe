package com.example.observee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.observee.station.WeatherStation
import com.example.observee.station.WeatherStationBuiltIn
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private val mWeatherMySelfStr = StringBuilder()
    private val mWeatherBuiltInStr = StringBuilder()
    private val mWeatherMySelf by lazy {
        WeatherStation()
    }

    private val mWeatherBuiltIn by lazy {
        WeatherStationBuiltIn()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.mWeatherBuildMySelfBt).setOnClickListener {
            clearContent(mWeatherMySelfStr)

            mWeatherMySelfStr.append(mWeatherMySelf.observerWeather())
            showData(findViewById(R.id.mWeatherBuildMySelfTv),
                mWeatherMySelfStr.toString())
        }

        findViewById<View>(R.id.mWeatherBuiltInBt).setOnClickListener {
            clearContent(mWeatherBuiltInStr)

            mWeatherBuiltInStr.append(mWeatherBuiltIn.observerWeather())
            showData(findViewById(R.id.mWeatherBuiltInTv),
                mWeatherBuiltInStr.toString())
        }

    }

    private fun showData(pTv: TextView?, pContentStr: String) {
        pTv?.text = pContentStr
    }

    private fun clearContent(pStringBuilder: StringBuilder) {
        pStringBuilder.delete(0, pStringBuilder.length)
    }
}