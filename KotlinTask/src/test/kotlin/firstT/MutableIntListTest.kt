import org.junit.Assert.*
import org.junit.Test
import kotlin.math.sqrt


class MutableIntListTest {

    @Test
    fun testListSquare() {
        val list = MutableIntList().apply { addAll(listOf(2, 4, 6)) }
        list.square()
        assertEquals("List should contain squared elements [4, 16, 36]", listOf(4, 16, 36), list)
    }

    @Test
    fun testSingleElementListSquare() {
        val list = MutableIntList().apply { add(3) }
        list.square()
        assertEquals("List should contain squared element [9]", listOf(9), list)
    }

    @Test
    fun testEmptyListSquare() {
        val list = MutableIntList()
        list.square()
        assertTrue("List should be empty", list.isEmpty())
    }

    @Test
    fun testNegativeNumbersSquare() {
        val list = MutableIntList().apply { addAll(listOf(-2, 4, -6)) }
        list.square()
        assertEquals("List should contain squared elements [4, 16, 36]", listOf(4, 16, 36), list)
    }

    @Test
    fun testLargeNumbersSquareThrows() {
        val list = MutableIntList().apply { add(Int.MAX_VALUE) }
        assertThrows(IllegalArgumentException::class.java) { list.square() }
    }

    @Test
    fun testLargeNumbersSquareNoThrow() {
        val list = MutableIntList().apply { add(sqrt(Int.MAX_VALUE.toDouble()).toInt()) }
        list.square()
        assertEquals("List should contain squared element [2147395600]", listOf(2147395600), list)
    }
}

