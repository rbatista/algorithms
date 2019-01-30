/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/
 */
package com.raphaelnegrisoli.hackerrank.sorting

import java.lang.StringBuilder


fun countInversions(arr: Array<Int>): Long {

    return mergeSort(arr, Array(arr.size) { 0 }, 0, arr.size - 1)
}

fun mergeSort(arr: Array<Int>, temp: Array<Int>, begin: Int, endIncluded: Int): Long {

    if (begin >= endIncluded) {

        return 0
    }

    val middle = (begin + endIncluded) / 2
    var swaps = mergeSort(arr, temp, begin, middle)
    swaps += mergeSort(arr, temp, middle + 1, endIncluded)
    return swaps + mergeHalves(arr, temp, begin, endIncluded)
}

fun mergeHalves(arr: Array<Int>, temp: Array<Int>, begin: Int, endIncluded: Int): Long {

    val middle = (begin + endIncluded) / 2
    var left = begin
    var right = middle + 1
    var index = begin
    var swaps = 0L

    while (left <= middle && right <= endIncluded) {

        if (arr[left] <= arr[right]) {
            temp[index] = arr[left]
            left++
        } else {
            temp[index] = arr[right]
            swaps += right - index
            right++
        }

        index++
    }

    while (left <= middle) {

        temp[index++] = arr[left++]
    }

    while (right <= endIncluded) {

        temp[index++] = arr[right++]
    }

    System.arraycopy(temp, begin, arr, begin, endIncluded - begin + 1)

    return swaps
}


fun main(args: Array<String>) {

    val datasets = readLine()!!.trim().toInt()

    val out = StringBuilder()
    for (i in 0 until datasets) {

        val elements = readLine()!!.trim().toInt()
        val arr = readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray()
        
        out.append(countInversions(arr)).append("\n")
    }

    println(out)
}