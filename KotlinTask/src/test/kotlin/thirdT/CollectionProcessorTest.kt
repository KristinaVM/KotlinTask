import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class CollectionProcessorTest {

    private val processor = CollectionProcessor()

    @Test
    fun testProcessCollection() {
        val collection = listOf(1.0, 2.0, 3.0, 4.0, 5.0, null)
        val result = processor.calculate(collection)
        assertEquals("Failed for collection with positive numbers", 24.5, result, 0.0001)
    }

    @Test
    fun testProcessCollectionWithNegativeNumbers() {
        val collection = listOf(-1.0, -2.0, -3.0, -4.0, -5.0, null)
        val result = processor.calculate(collection)
        assertEquals("Failed for collection with negative numbers", 15.5, result, 0.0001)
    }

    @Test
    fun testProcessCollectionWithOnlyNulls() {
        val collection = listOf(null, null, null, null, null)
        val result = processor.calculate(collection)
        assertEquals("Failed for collection with only nulls", 0.0, result, 0.0001)
    }

    @Test
    fun testProcessCollectionWithAllNumbersGreaterThan25() {
        val collection = listOf(30.0, 55.0, 40.0, 65.0, 50.0)
        val result = processor.calculate(collection)
        assertEquals("Failed for collection with all numbers greater than 25", 0.0, result, 0.0001)
    }

    @Test
    fun testCalculateWithTextInList() {
        val list = listOf(1.0, 2.0, 3.0, "text", 4.0, 5.0, null)
        val result = processor.calculate(list)
        assertEquals("Failed for collection with text in list", 24.5, result, 0.0001)
    }
}