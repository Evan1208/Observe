package com.example.observee.station

import com.example.observee.forBuiltIn.CurrentConditionsDisplay
import com.example.observee.forBuiltIn.ForecastDisplay
import com.example.observee.forBuiltIn.StatisticsDisplay
import com.example.observee.forBuiltIn.WeatherData
import java.util.*


class WeatherStationBuiltIn {

    private val mWeatherData by lazy {
        val iWeatherData = WeatherData()
        val iCurrentDisplay = CurrentConditionsDisplay(iWeatherData)
        val iStatistics = StatisticsDisplay(iWeatherData)
        val iForecast  = ForecastDisplay(iWeatherData)
        iWeatherData
    }


    fun observerWeather(): String {
        mWeatherData.setMeasurements(Random().nextFloat(), Random().nextFloat(), Random().nextFloat())
        return mWeatherData.getDisplay()
    }
}