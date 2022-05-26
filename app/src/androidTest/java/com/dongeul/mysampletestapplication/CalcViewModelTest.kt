package com.dongeul.mysampletestapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import com.google.common.truth.Truth.assertThat

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations:Calculations

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)

        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.873)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun caclulateArea_radiusSent_updateLiveData(){
        calcViewModel.calculateArea(2.1.toDouble())
        val result = calcViewModel.areaValue.value
        assertThat(result).isEqualTo("13.873")

    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calcViewModel.calculateCircumference(1.0)
        val result = calcViewModel.areaValue.value
        assertThat(result).isEqualTo(0.0)
    }

    @After
    fun tearDown() {
    }
}