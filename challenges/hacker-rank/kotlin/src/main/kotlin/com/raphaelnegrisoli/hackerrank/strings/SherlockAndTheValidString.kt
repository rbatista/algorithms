/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/
 */
package com.raphaelnegrisoli.hackerrank.strings

import kotlin.math.absoluteValue


fun main(args: Array<String>) {

    val str = readLine().orEmpty().trim()

    val frequencies = mutableMapOf<Char, Long>()
    for (char in str) {

        frequencies[char] = (frequencies[char] ?: 0) + 1
    }

    val counts = mutableMapOf<Long, Long>()
    for ((_, value) in frequencies) {

        counts[value] = (counts[value] ?: 0) + 1
    }

    val valid = when {
        counts.size == 1 -> true
        counts.size > 2 -> false
        else -> {
            val it = counts.iterator()
            val (key1, value1) = it.next()
            val (key2, value2) = it.next()

            ((key1 - key2).absoluteValue == 1L && (value1 == 1L || value2 == 1L))
                    || (key1 == 1L && value1 == 1L)
                    || (key2 == 1L && value2 == 1L)
        }
    }

    println(if (valid) "YES" else "NO")
}