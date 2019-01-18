/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/
 *
 * Solution in 3 * n
 */
package com.raphaelnegrisoli.hackerrank

fun main(args: Array<String>) {

    val (_, _) = readLine().orEmpty()
            .split(" ")
            .map { it.toInt() }

    val magazine = readLine().orEmpty().split(" ")
    val note = readLine().orEmpty().split(" ")

    val map = magazine.groupBy { it }
        .mapValues { it.value.size }
        .toMutableMap()


    val match = note.all {
        val value = (map[it] ?: 0) - 1
        map[it] = value

        value >= 0
    }

   println(if (match) "Yes" else "No")
}