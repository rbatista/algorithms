/**
 * https://www.hackerrank.com/challenges/counting-valleys/
 */
package com.raphaelnegrisoli.hackerrank


fun main(args: Array<String>) {

    readLine()
    val path = readLine() ?: ""

    var position = 0
    var valley = 0
    for (s in path) {

        if (s == 'D') position--
        else if (s == 'U') position++

        if (s == 'D' && position == -1) {
            valley++
        }
    }

    println(valley)
}
