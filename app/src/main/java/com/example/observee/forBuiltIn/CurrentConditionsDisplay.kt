package com.example.observee.forBuiltIn

import android.util.Log
import com.example.observee.model.DisplayElement
import com.example.observee.station.WeatherStationBuiltIn
import java.util.*

class CurrentConditionsDisplay(private val mObservable:WeatherData): Observer, DisplayElement {

    private var mTemperature:Float = 0f
    private var mHumidity:Float = 0f
    private var mPressure:Float = 0f


    init {
        mObservable.addObserver(this)
        mObservable.registerDisplay(this)
    }


    override fun display():String {
        Log.v("aaa", "${this::class.java.simpleName}\n$mTemperature F degrees and $mHumidity % humidity.")
        return "Current conditions:\n" +
                "$mTemperature F degrees and $mHumidity % humidity."
    }


    override fun update(obs: Observable?, arg: Any?) {
        if( obs != null && obs is WeatherData) {
            mTemperature = obs.getTemperature()
            mHumidity = obs.getHumidity()
            mPressure = obs.getPressure()
            display()
        }
    }

}