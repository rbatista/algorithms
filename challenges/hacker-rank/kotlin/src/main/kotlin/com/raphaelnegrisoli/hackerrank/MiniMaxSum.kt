/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
package com.raphaelnegrisoli.hackerrank

import java.util.*

fun miniMaxSum(arr: Array<Int>) {

    var min = arr[0]
    var max = arr[0]
    var total = 0L
    for (i in arr) {
        total += i
        if (min > i) min = i
        if (max < i) max = i
    }

    println("${total - max} ${total - min}")

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}