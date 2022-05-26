package com.dongeul.mysampletestapplication

class MyCalc : Calculations {

    private val pi = 3.14

    override fun calculateArea(radius: Double): Double {
        return 2 * pi * radius
    }

    override fun calculateCircumference(radius: Double): Double {
        return pi * radius * radius
    }
}


interface Calculations {
    fun calculateArea(radius: Double): Double

    fun calculateCircumference(radius: Double): Double
}