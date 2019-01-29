package com.raphaelnegrisoli.hackerrank

import kotlin.math.absoluteValue


fun main(args: Array<String>) {

    val a = readLine()!!
    val b = readLine()!!

    val countA = a.groupBy { it }.mapValues { it.value.size }.toMutableMap()
    val countB = b.groupBy { it }.mapValues { it.value.size }.toMutableMap()

    var count = 0L
    for ((key, value) in countA) {

        val bValue = countB[key] ?: 0

        count += (value - bValue).absoluteValue
        countB.remove(key)
    }

    for ((_, value) in countB) {

        count += value
    }

    println(count)
}