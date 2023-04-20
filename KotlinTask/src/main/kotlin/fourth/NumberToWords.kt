class NumberToWords {

    private val units = arrayOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    private val teens = arrayOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    private val tens = arrayOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    private val hundreds = arrayOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")

    fun convert(n: Int): String {
       if (n < 0 || n > 1000) {
            throw IllegalArgumentException("Number should be between 0 and 1000")
        }

        if (n == 0) {
            return "ноль"
        }

        if (n == 1000) {
            return "тысяча"
        }

        val sb = StringBuilder()
        if (n / 100 > 0) {
            sb.append(hundreds[n / 100]).append(" ")
        }

        if (n % 100 < 10) {
            sb.append(units[n % 10])
        } else if (n % 100 < 20) {
            sb.append(teens[n % 10])
        } else {
            sb.append(tens[n % 100 / 10]).append(" ").append(units[n % 10])
        }

        return sb.toString().trim()
    }
}

fun main() {
    val numberToWords = NumberToWords()
    while (true) {
        print("Enter a number between 0 and 1000: ")
        val input = readLine()
        try {
            val number = input?.toInt() ?: throw IllegalArgumentException("Invalid input")
            println(numberToWords.convert(number))
            break
        } catch (e: IllegalArgumentException) {
            println("Invalid input. Please try again.")
        }
    }
}