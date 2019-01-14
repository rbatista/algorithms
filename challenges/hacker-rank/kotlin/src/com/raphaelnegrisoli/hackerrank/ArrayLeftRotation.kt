/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/
 */
package com.raphaelnegrisoli.hackerrank

fun rotateLeftIndex(size: Int, rotations: Int, array: List<Int>) {

    for (i in 0 until size) {

        print("${array[(rotations + i) % size]} ")
    }
}

fun printArray(array: Array<Int>) {
    array.forEachIndexed { index, i ->
        print(i)
        if (index < array.size - 1) print(" ")
    }
}

fun main(args: Array<String>) {

    val line1 = readLine()?.split(" ")?.map { it.toInt() }
    val size = line1?.getOrNull(0) ?: 0
    val rotations = line1?.getOrNull(1) ?: 0

    val array = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: arrayOf()
    val newArray = Array(size) { 0 }

    for (i in 0 until size) {

        val index = (i + rotations) % size
        newArray[i] = array[index]
    }

    println(newArray.joinToString(" "))
}