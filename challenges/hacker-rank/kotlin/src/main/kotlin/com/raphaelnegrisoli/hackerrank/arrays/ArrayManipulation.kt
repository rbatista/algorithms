/**
 * https://www.hackerrank.com/challenges/crush/
 */
package com.raphaelnegrisoli.hackerrank.arrays

import java.util.*

/**
 * Solution in 2 * m
 */
fun main(args: Array<String>) {

    val (size, operations) =  readLine().orEmpty().trim()
        .split(" ")
        .map { it.toInt() }
        .zipWithNext()
        .first()


    val array = TreeMap<Int, Long>()

    for (i in 0 until operations) {

        val (begin, end, value) = readLine().orEmpty().trim()
            .split(" ")

        array[begin.toInt() - 1] = (array[begin.toInt() - 1] ?: 0) + value.toLong()
        array[end.toInt()] = (array[end.toInt()] ?: 0) - value.toLong()

    }

    var max = 0L
    var current = 0L
    array.forEach {
        current += it.value
        if (current > max) max = current
    }

    println(max)
}