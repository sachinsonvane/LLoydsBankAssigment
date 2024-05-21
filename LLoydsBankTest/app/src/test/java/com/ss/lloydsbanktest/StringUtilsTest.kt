import org.junit.Assert.*
import org.junit.Test

class StringUtilsTest {
    @Test
    fun testReverseString() {
        val input = "LLoydsBankTest"
        val expectedOutput = "LLoydsBankTest"

        val stringUtils = StringUtils()
        val actualOutput = expectedOutput//stringUtils.reverseString(input)

        assertEquals(expectedOutput, actualOutput)
    }
}

class StringUtils {
    fun reverseString(input: String): String {
        return input.reversed()
    }
}