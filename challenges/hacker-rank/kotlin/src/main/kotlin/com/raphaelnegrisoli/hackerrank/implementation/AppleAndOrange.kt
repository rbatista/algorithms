/**
 * https://www.hackerrank.com/challenges/apple-and-orange/
 */
package com.raphaelnegrisoli.hackerrank.implementation

fun main(args: Array<String>) {

    val (houseBegin, houseEnd) = readLine()!!.trim().split(" ").map { it.toInt() }
    val (appleTree, orangeTree) = readLine()!!.trim().split(" ").map { it.toInt() }
    val (applesSize, orangesSize) = readLine()!!.trim().split(" ").map { it.toInt() }

    val apples = readLine()!!.trim().split(" ").map { it.toInt() }
    val oranges = readLine()!!.trim().split(" ").map { it.toInt() }

    val appleCount = apples.map { it + appleTree }
        .filter { it in houseBegin..houseEnd }
        .count()

    val orangeCount = oranges.map { it + orangeTree }
        .filter { it in houseBegin..houseEnd }
        .count()

    println(appleCount)
    println(orangeCount)
}

