package com.example.observee.station

import com.example.observee.data.CurrentConditionsDisplay
import com.example.observee.data.ForecastDisplay
import com.example.observee.data.StatisticsDisplay
import com.example.observee.data.WeatherData
import java.util.*

class WeatherStation {
    private val iWeatherData by lazy {
        val iWeatherData = WeatherData()
        CurrentConditionsDisplay(iWeatherData)
        StatisticsDisplay(iWeatherData)
        ForecastDisplay(iWeatherData)
        iWeatherData
    }

    fun observerWeather(): String {

        iWeatherData.setMeasurements(Random().nextFloat(), Random().nextFloat(), Random().nextFloat())
        return iWeatherData.getDisplay()
    }
}