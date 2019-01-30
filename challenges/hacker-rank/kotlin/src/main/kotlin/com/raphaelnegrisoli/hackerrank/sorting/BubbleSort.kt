/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 */
package com.raphaelnegrisoli.hackerrank.sorting


fun main(args: Array<String>) {

    val n = readLine()!!.trim().toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()

    var count = 0
    for (i in 0 until  n - 1) {

        for (j in i until n) {

            if (arr[i] > arr[j]) {

                val tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp

                count++
            }
        }
    }

    println("Array is sorted in $count swaps.")
    println("First Element: ${arr[0]}")
    println("Last Element: ${arr[n-1]}")
}
