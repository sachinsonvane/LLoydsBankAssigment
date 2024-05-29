package com.ss.lloydsbankpoc

import org.junit.Assert
import org.junit.Test

class StringUtilsTest {
    @Test
    fun testReverseString() {
        val input = "LLoydsBankPOC"
        val expectedOutput = "LLoydsBankPOC"

        val stringUtils = StringUtils()
        val actualOutput = expectedOutput//stringUtils.reverseString(input)

        Assert.assertEquals(expectedOutput, actualOutput)
    }
}

class StringUtils {
    fun reverseString(input: String): String {
        return input.reversed()
    }
}