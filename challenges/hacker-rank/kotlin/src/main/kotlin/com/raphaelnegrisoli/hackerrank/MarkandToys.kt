/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 */
package com.raphaelnegrisoli.hackerrank

fun main(args: Array<String>) {

    val (_, k) = readLine()!!.trim().split(" ").map { it.toInt() }
    val arr = readLine()!!.trim().split(" ").map { it.toInt() }

    var cost = 0
    for ((index, price) in arr.sorted().withIndex()) {

        if (price + cost > k) {

            print(index)
            break
        }

        cost += price
    }

}