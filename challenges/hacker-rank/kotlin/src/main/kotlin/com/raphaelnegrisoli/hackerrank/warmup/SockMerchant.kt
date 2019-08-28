/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */

fun main() {
    readLine()
    val numbers = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()

    val summary = mutableMapOf<Int, Int>()

    numbers.forEach {
        summary.compute(it) { _, value -> if (value == null) 1 else value + 1 }
    }

    val pairs = summary.values
            .map { it / 2 }
            .sum()

    println(pairs)
}
