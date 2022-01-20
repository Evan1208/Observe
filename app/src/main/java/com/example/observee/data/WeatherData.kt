package com.example.observee.data

import com.example.observee.model.DisplayElement
import com.example.observee.model.Observer
import com.example.observee.model.Subject
import java.lang.StringBuilder

class WeatherData: Subject {
    private val mArrayObservers = arrayListOf<Observer>()
    private val mArrayDisplayElement = arrayListOf<DisplayElement>()
    private var mTemperature = 0f
    private var mHumidity = 0f
    private var mPressure = 0f
    private val mStringBuilder = StringBuilder()


    fun setMeasurements(pTemperature: Float, pHumidity: Float, pPressure:Float) {
        mTemperature = pTemperature
        mHumidity = pHumidity
        mPressure = pPressure
        measurementsChanged()
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    override fun registerDisplay(pDisplay: DisplayElement) {
        mArrayDisplayElement.add(pDisplay)
    }

    override fun removeDisplay(pDisplay: DisplayElement) {
        mArrayDisplayElement.remove(pDisplay)
    }


    override fun registerObserver(pObserver: Observer) {
        mArrayObservers.add(pObserver)
    }

    override fun removeObserver(pObserver: Observer) {

        mArrayObservers.remove(pObserver)
    }

    override fun notifyObservers() {
        for( iObserver in mArrayObservers) {
            iObserver.upData(mTemperature, mHumidity, mPressure)
        }
    }

    fun getDisplay():String {
        mStringBuilder.delete(0, mStringBuilder.length)
        for( iDisplay in mArrayDisplayElement) {
            mStringBuilder.append(iDisplay.display()+"\n")
        }
        return mStringBuilder.toString()
    }
}