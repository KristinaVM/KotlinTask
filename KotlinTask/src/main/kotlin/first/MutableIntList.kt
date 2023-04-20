import kotlin.math.sqrt

class MutableIntList : ArrayList<Int>()

fun MutableIntList.square() {
    for (i in 0 until size) {
        if (this[i] > sqrt(Int.MAX_VALUE.toDouble())) {
            throw IllegalArgumentException("Cannot square a number greater than ${sqrt(Int.MAX_VALUE.toDouble())}")
        }
        this[i] = this[i] * this[i]
    }
}

fun main() {
    val list = MutableIntList()
    while (true) {
        print("Введите число (для завершения введите 'stop'): ")
        val input = readLine()
        if (input == "stop") break
        try {
            val number = input?.toInt()
            if (number != null) {
                list.add(number)
            }
        } catch (e: NumberFormatException) {
            println("Неверный формат числа")
        }
    }
    list.square()
    println("Введенные числа в квадрате: $list")
}