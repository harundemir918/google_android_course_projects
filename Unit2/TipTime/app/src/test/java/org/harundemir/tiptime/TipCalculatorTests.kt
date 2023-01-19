package org.harundemir.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount: Double = 10.00
        val tipPercent: Double = 20.00
        val expectedTip: String = "₺2,00"
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}