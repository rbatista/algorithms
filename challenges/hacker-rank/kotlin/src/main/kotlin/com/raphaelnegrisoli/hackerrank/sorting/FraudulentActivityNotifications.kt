package com.raphaelnegrisoli.hackerrank.sorting


fun main(args: Array<String>) {

    val (_, days) = readLine()!!.trim().split(" ").map { it.toInt() }
    val expenditures = readLine()!!.trim().split(" ").map { it.toInt() }

    val alerts = fraudulentActivity(expenditures, days)
    println(alerts)

}

fun fraudulentActivity(expenditures: List<Int>, days: Int): Int {

    val counts = MutableList(201) { 0 }
    var alerts = 0
    for (i in 0 until expenditures.size) {

        if (i >= days) {

            var countSum = 0
            var firstMedian = 0
            var secondMedian = 0

            // find the first median
            while (countSum < (days + 1) / 2) {

                countSum += counts[firstMedian++]
            }

            firstMedian--

            // find the second median if necessary
            if (days % 2 == 0) {

                secondMedian = if (countSum == days / 2) {
                    var secondIndex = firstMedian + 1
                    while (counts[secondIndex] == 0) secondIndex++
                    secondIndex
                } else {
                    firstMedian
                }
            }

            val median = if (days % 2 != 0) firstMedian * 2 else firstMedian + secondMedian
            if (expenditures[i] >= median) alerts++

            // remove old
            counts[expenditures[i - days]]--
        }

        // add next
        counts[expenditures[i]] += 1

    }

    return alerts
}