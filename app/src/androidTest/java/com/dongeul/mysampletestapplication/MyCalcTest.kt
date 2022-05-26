package com.dongeul.mysampletestapplication

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class MyCalcTest {
    private lateinit var myCalc:MyCalc

    @Before
    fun setUp() {
        myCalc = MyCalc()
    }

    @Test
    fun `13_8474와_같은지`(){
        val result = myCalc.calculateCircumference(2.1)
        assertThat(result).isEqualTo(13.8474)
    }


    @Test
    fun `이건_무슨_함수_입니까`() {
    }

    @Test
    fun calculateCircumference() {
    }

    @Test
    fun `Livedata_테스트`() {


    }

    @After
    fun tearDown() {
    }
}