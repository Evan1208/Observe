package com.example.observee.model

interface Observer {
    fun upData(pTemperature: Float, pHumidity: Float, pPressure: Float)
}