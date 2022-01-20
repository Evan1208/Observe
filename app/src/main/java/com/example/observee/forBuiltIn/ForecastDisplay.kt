package com.example.observee.forBuiltIn

import android.util.Log
import com.example.observee.model.DisplayElement
import java.util.*

class ForecastDisplay(private val mObservable:WeatherData): Observer, DisplayElement {

    private var mTemperature:Float = 0f
    private var mHumidity:Float = 0f
    private var mPressure:Float = 0f

    private var mCurrentPressure = 29.92f
    private var mLastPressure = 0f


    init {
        mObservable.addObserver(this)
        mObservable.registerDisplay(this)
    }


    override fun display():String {
        Log.v("aaa", "${this::class.java.simpleName}\n$mTemperature F degrees and $mHumidity % humidity.")
        return "Forecast:\n" +
                "$mTemperature F degrees, $mHumidity % humidity and $mPressure, Pressure."
    }


    override fun update(obs: Observable?, arg: Any?) {
        if( obs != null && obs is WeatherData) {
            mCurrentPressure = obs.getPressure()
            display()
        }
    }

}