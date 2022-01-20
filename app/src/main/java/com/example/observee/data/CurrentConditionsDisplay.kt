package com.example.observee.data

import android.util.Log
import com.example.observee.model.DisplayElement
import com.example.observee.model.Observer
import com.example.observee.model.Subject

class CurrentConditionsDisplay(private val mWeatherData:Subject): Observer, DisplayElement {

    private var mTemperature:Float = 0f
    private var mHumidity:Float = 0f
    private var mPressure:Float = 0f


    init {
        mWeatherData.registerDisplay(this)
        mWeatherData.registerObserver(this)
    }


    override fun display():String {
        Log.v("aaa", "${this::class.java.simpleName}\n$mTemperature F degrees and $mHumidity % humidity.")
        return "Current conditions:\n" +
                "$mTemperature F degrees and $mHumidity % humidity."
    }

    override fun upData(pTemperature: Float, pHumidity: Float, pPressure: Float) {
        mTemperature = pTemperature
        mHumidity = pHumidity
        mPressure = pPressure
        display()
    }

}