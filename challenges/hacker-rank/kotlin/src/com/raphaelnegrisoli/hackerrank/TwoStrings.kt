/**
 * https://www.hackerrank.com/challenges/two-strings
 *
 * Solution in n * m
 */
package com.raphaelnegrisoli.hackerrank

fun main(args: Array<String>) {

    val p = readLine().orEmpty().toInt()

    for (i in 0 until p) {

        val first = readLine().orEmpty()
        val second = readLine().orEmpty()

        val s = first.toSet()
        val match = second.any { s.contains(it) }

        println(if (match) "YES" else "NO")
    }
}