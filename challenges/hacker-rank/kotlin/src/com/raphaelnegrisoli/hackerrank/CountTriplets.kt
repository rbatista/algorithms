package com.raphaelnegrisoli.hackerrank

import java.util.*
import kotlin.collections.HashMap

fun countTriplets(arr: List<Long>, ratio: Long): Long {

    val counts = hashMapOf<Long, MutableList<Int>>()
    for ((index, value) in arr.withIndex()) {

        if (!counts.contains(value)) {

            counts[value] = ArrayList()
        }

        counts[value]!!.add(index)
    }

    var result = 0L
    for ((index, value) in arr.withIndex()) {

        val value2 = value * ratio
        val value3 = value * ratio * ratio

        if (!counts.contains(value2) || !counts.contains(value3)) continue

        // DOES NOT GUARANTEE i < j < k
        val count2 = count(counts[value2]!!, index)
        val count3 = count(counts[value3]!!, index)

        result += count2 * count3
    }

    return result
}

private fun count(
    counts: MutableList<Int>,
    index: Int
): Int {
    var valueIndexCount = Collections.binarySearch(counts, index)
    if (valueIndexCount < 0) valueIndexCount = (valueIndexCount + 1) * -1
    return counts.subList(valueIndexCount, counts.size).size
}

fun main(args: Array<String>) {

    val (_, ratio) = readLine().orEmpty().trim()
        .split(" ")
        .map { it.toLong() }
    val arr = readLine().orEmpty().trim()
        .split(" ")
        .map { it.toLong() }

    val result = countTriplets(arr, ratio)
    println(result)
}