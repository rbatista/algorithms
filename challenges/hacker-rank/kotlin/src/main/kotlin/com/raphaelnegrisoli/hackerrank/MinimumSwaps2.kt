/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/
 */
package com.raphaelnegrisoli.hackerrank

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {

    val size = readLine()?.toInt() ?: throw IllegalArgumentException("No size available")
    val arr = readLine()?.split(" ")?.map { it.trim().toInt() }?.toTypedArray()
        ?: throw IllegalArgumentException("No array found")

    var swaps = 0
    var i = 0
    while (i < size) {

        if (arr[i] != i + 1) {

            val temp = arr[i]
            arr[i] = arr[arr[i] -1]
            arr[temp - 1] = temp
            swaps++
        } else {

            i++
        }
    }

    println(swaps)

}