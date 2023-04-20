import java.time.LocalDate
import java.util.logging.Handler
import kotlin.math.round

class TypeCasting {
    fun typeCasting(obj: Any?) {
        when (obj) {
            is String -> {
                val length = obj.length
                println("Я получил String = '$obj', ее длина равна $length символ")
            }

            is Int -> {
                val square = obj * obj
                println("Я получил Int = $obj, его квадрат равен $square")
            }

            is Double -> {
                val rounded = if (obj % 1 == 0.0) {
                    String.format("%.0f", obj)
                } else {
                    String.format("%.2f", obj)
                }
                println("Я получил Double = $obj, это число округляется до $rounded")

            }

            is LocalDate -> {
                val foundationDate = LocalDate.of(2006, 12, 24)
                val message = if (obj < foundationDate) {
                    "эта дата меньше чем дата основания Tinkoff"
                } else {
                    "эта дата больше или равна дате основания Tinkoff"
                }
                println("Я получил LocalDate = $obj, $message")
            }

            null -> {
                println("Объект равен null")
            }

            else -> {
                println("Мне этот тип неизвестен")
            }

        }
    }
}


fun main() {
    val tc = TypeCasting()
    tc.typeCasting("Privet")
    tc.typeCasting(147)
    tc.typeCasting(145.0)
    tc.typeCasting(145.2817812)
    tc.typeCasting(LocalDate.of(1990, 1, 1))
    tc.typeCasting(Handler::class)
    tc.typeCasting(null)

}