/**
 * https://www.hackerrank.com/challenges/crush/
 */
package com.raphaelnegrisoli.hackerrank

import java.util.*


/**
 * Solution in {@sample m^2 + m}
 */
fun treeSolution(operations: Int) {

    val tree = TreeMap<Long, Long>()
    tree[1L] = 0

    for (i in 0 until operations) {

        val (begin, end, value) = readLine().orEmpty().trim()
            .split(" ")
            .map { it.toLong() }


        val v1 = (tree.floorEntry(begin).value ?: 0L) + value
        val v2 = (tree.floorEntry(end + 1).value ?: 0L)

        tree[begin] = v1
        tree[end + 1] = v2

        // TODO optimize this
        tree.subMap(begin + 1, end + 1).replaceAll { _, v -> v + value }
    }

    println(tree.maxBy { it.value } ?.value ?: 0)
}

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