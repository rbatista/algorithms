/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 */
package com.raphaelnegrisoli.hackerrank.search

fun main(args: Array<String>) {

    val trips = readLine()!!.trim().toInt()

    for (t in 0 until trips) {
        val money = readLine()!!.trim().toInt()
        readLine() // ignore cost size
        val costs = readLine()!!.trim().split(" ").map { it.toInt() }

        val indexByCost = hashMapOf<Int, Int>()
        for ((index, cost) in costs.withIndex()) {

            if (indexByCost.containsKey(cost)) {

                println("${indexByCost[cost]!! + 1} ${index + 1}")
                break
            }

            indexByCost.putIfAbsent(money - cost, index)
        }

    }
}