import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDate
import org.hamcrest.MatcherAssert.assertThat


class TypeCastingTest {
    private val typeCasting = TypeCasting()

    @Test
    fun testString() {
        val obj = "test"
        val expectedOutput = "Я получил String = 'test', ее длина равна 4 символ"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }.trim()
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testInt() {
        val obj = 5
        val expectedOutput = "Я получил Int = 5, его квадрат равен 25"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }.trim()
        assertThat(actualOutput, equalTo(expectedOutput))
    }

    @Test
    fun testDoubleRoundingLessTwo() {
        val obj = 145.0
        val expectedOutput = "Я получил Double = 145.0, это число округляется до 145"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }
        assertEquals(expectedOutput.trim(), actualOutput.trim())
    }

    @Test
    fun testDoubleRoundingMoreTwo() {
        val obj = 145.02564522
        val expectedOutput = "Я получил Double = 145.02564522, это число округляется до 145,03"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }
        assertEquals(expectedOutput.trim(), actualOutput.trim())
    }

    @Test
    fun testLocalDate() {
        val obj = LocalDate.of(2023, 4, 17)
        val expectedOutput = "Я получил LocalDate = 2023-04-17, эта дата больше или равна дате основания Tinkoff"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }
        assertNotEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testNull() {
        val obj: Any? = null
        val expectedOutput = "Объект равен null"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }
        assertNotNull(actualOutput)
        assertTrue(actualOutput.contains(expectedOutput))
    }

    @Test
    fun testUnknownType() {
        val obj = Any()
        val expectedOutput = "Мне этот тип неизвестен"
        val actualOutput = captureOutput { typeCasting.typeCasting(obj) }
        assertNotSame(expectedOutput, actualOutput)
    }

    private fun captureOutput(block: () -> Unit): String {
        val out = System.out
        val bytes = ByteArrayOutputStream()
        System.setOut(PrintStream(bytes))
        block()
        System.setOut(out)
        return bytes.toString()
    }
}