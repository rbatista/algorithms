/**
 * https://www.hackerrank.com/challenges/crush/
 */
package com.raphaelnegrisoli.hackerrank

import java.util.*

fun main(args: Array<String>) {

    val (_, operations) =  readLine().orEmpty().trim()
        .split(" ")
        .map { it.toInt() }
        .zipWithNext()
        .first()

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

        tree.subMap(begin + 1, end + 1).replaceAll { _, v -> v + value }

    }

    println(tree.maxBy { it.value } ?.value ?: 0)
}