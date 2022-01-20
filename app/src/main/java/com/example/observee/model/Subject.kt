package com.example.observee.model

interface Subject {
    fun registerDisplay(pDisplay:DisplayElement)
    fun removeDisplay(pDisplay: DisplayElement)

    fun registerObserver(pObserver: Observer)
    fun removeObserver(pObserver: Observer)
    fun notifyObservers()
}