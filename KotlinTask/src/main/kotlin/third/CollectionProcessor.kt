import java.math.RoundingMode
import kotlin.math.floor

class CollectionProcessor {
    fun calculate(list: List<Double?>): Double {
        return list.asSequence()
            .filterNotNull()
            .map {
                if (floor(it) % 2 == 0.0) {
                    it * it
                } else {
                    it / 2
                }
            }
            .filter { it <= 25 }
            .sortedDescending()
            .take(10)
            .sum()
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .toDouble()
    }
}

fun main() {
    val processor = CollectionProcessor()
    val list = mutableListOf<Double?>()
    var input: String?
    while (true) {
        print("Enter a number (or 'stop' to finish): ")
        input = readLine()
        if (input == "stop") {
            break
        }
        try {
            val number = input?.toDouble()
            list.add(number)
        } catch (e: NumberFormatException) {
            println("Invalid input, please enter a valid number.")
        }
    }
    val result = processor.calculate(list)
    println("Result: $result")
}