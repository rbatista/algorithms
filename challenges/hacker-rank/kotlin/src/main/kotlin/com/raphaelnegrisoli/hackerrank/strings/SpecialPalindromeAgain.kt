/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/
 */
package com.raphaelnegrisoli.hackerrank.strings


fun main(args: Array<String>) {


    readLine()!!.toInt()
    val str = readLine()!!

    val pairs = mutableListOf<Pair<Char, Int>>()

    for (char in str) {

        val pair = if (pairs.isNotEmpty()) pairs[pairs.size - 1] else Pair(' ', 0)

        if (char == pair.first) {
            pairs[pairs.size - 1] = Pair(char, pair.second + 1)
        } else {

            pairs.add(Pair(char, 1))
        }
    }

    var palindromes = 0
    for (i in 0 until pairs.size) {

        val count = pairs[i].second

        if (count == 1 && i > 0 && i < pairs.size - 1) {

            val before = pairs[i - 1]
            val next = pairs[i + 1]
            if (before.first == next.first) {

                palindromes += Math.min(before.second, next.second)
            }
        }

        palindromes += count * (count + 1) / 2
    }

    println(palindromes)

}