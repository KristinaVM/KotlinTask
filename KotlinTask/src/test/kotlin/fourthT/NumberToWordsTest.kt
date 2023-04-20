import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows


class NumberToWordsTest {

    private val numberToWords = NumberToWords()

    @Test
    fun testConvertZero() {
        assertEquals("Conversion of 0 should return 'ноль'", "ноль", numberToWords.convert(0))
    }

    @Test
    fun testConvertThousand() {
        assertEquals("Conversion of 1000 should return 'тысяча'", "тысяча", numberToWords.convert(1000))
    }

    @Test
    fun testConvertLessThanTwenty() {
        assertEquals("Conversion of 18 should return 'восемнадцать'", "восемнадцать", numberToWords.convert(18))
    }

    @Test
    fun testConvertLessThanHundred() {
        assertEquals("Conversion of 72 should return 'семьдесят два'", "семьдесят два", numberToWords.convert(72))
    }

    @Test
    fun testConvertLessThanThousand() {
        assertEquals(
            "Conversion of 975 should return 'девятьсот семьдесят пять'",
            "девятьсот семьдесят пять",
            numberToWords.convert(975)
        )
    }


    @Test
    fun testConvertNegative() {
        val exception = assertThrows(
            "Conversion of negative number should throw IllegalArgumentException",
            IllegalArgumentException::class.java
        ) {
            numberToWords.convert(-1)
        }
        assertEquals(
            "IllegalArgumentException message should be 'Number should be between 0 and 1000'",
            "Number should be between 0 and 1000",
            exception.message
        )
    }

    @Test
    fun testConvertGreaterThan1000() {
        val exception = assertThrows(
            "Conversion of number greater than 1000 should throw IllegalArgumentException",
            IllegalArgumentException::class.java
        ) {
            numberToWords.convert(1001)
        }
        assertEquals(
            "IllegalArgumentException message should be 'Number should be between 0 and 1000'",
            "Number should be between 0 and 1000",
            exception.message
        )
    }


}