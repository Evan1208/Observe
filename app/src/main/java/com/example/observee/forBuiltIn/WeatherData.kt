package com.example.observee.forBuiltIn

import com.example.observee.model.DisplayElement
import java.lang.StringBuilder
import java.util.*

class WeatherData: Observable() {
    private val mStringBuilder = StringBuilder()
    private val mArrayDisplayElement = arrayListOf<DisplayElement>()
    private var mTemperature = 0f
    private var mHumidity = 0f
    private var mPressure = 0f


    fun setMeasurements(pTemperature: Float, pHumidity: Float, pPressure:Float) {
        mTemperature = pTemperature
        mHumidity = pHumidity
        mPressure = pPressure
        measurementsChanged()
    }

    fun registerDisplay(pDisplay: DisplayElement) {
        mArrayDisplayElement.add(pDisplay)
    }

    fun removeDisplay(pDisplay: DisplayElement) {
        mArrayDisplayElement.remove(pDisplay)
    }


    fun getTemperature(): Float {
        return mTemperature
    }

    fun getHumidity(): Float {
        return mHumidity
    }

    fun getPressure(): Float {
        return mPressure
    }

    fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    fun getDisplay():String {
        mStringBuilder.delete(0, mStringBuilder.length)
        for( iDisplay in mArrayDisplayElement) {
            mStringBuilder.append(iDisplay.display()+"\n")
        }
        return mStringBuilder.toString()
    }

}