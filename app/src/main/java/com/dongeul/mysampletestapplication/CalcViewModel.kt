package com.dongeul.mysampletestapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CalcViewModel(
    private val calculations: Calculations
) : ViewModel() {
    var radius = MutableLiveData<String>()

    var area = MutableLiveData<String>()
    val areaValue: LiveData<String>
        get() = area

    var circumference = MutableLiveData<String>()
    val circumferenceValue: LiveData<String>
        get() = circumference

    fun calculate() {

        try {
            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                area.value = null
                circumference.value = null
            }
        } catch (e: Exception) {
            area.value = null
            circumference.value = null
        }
    }

    fun calculateCircumference(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        area.value = calculatedArea.toString()

    }

    fun calculateArea(radius: Double) {
        var calculatedArea: Double = try {
            calculations.calculateArea(radius)
        } catch (e: Exception) {
            13.8474
        }
        area.value = calculatedArea.toString()

    }

}