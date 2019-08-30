/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 */
package com.raphaelnegrisoli.hackerrank.warmup


fun main() {

    val str = readLine() ?: ""
    val size = readLine()?.toLong() ?: 0L

    println(repeatedString(str, size))
}

fun repeatedString(str: String, size: Long): Long {

    val repeatedA = str.filter { it == 'a' }.length
    val x = size / str.length
    val partial = size % str.length
    val partialA = str.substring(0 until partial.toInt())
            .filter { it == 'a' }.length
    return x * repeatedA + partialA
}