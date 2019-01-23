/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
package com.raphaelnegrisoli.hackerrank

import java.util.*

fun String.sort(): String {

    val charArray = this.toCharArray()
    Arrays.sort(charArray)
    return String(charArray)
}

fun sherlockAndAnagrams(word: String): Int {

    val counts = hashMapOf<String, Int>()
    for (s in 0 .. word.length - 2) {

        for (i in 0 until word.length - s) {

            val substring = (word.substring(i .. i + s)).sort()
            counts[substring] = (counts[substring] ?: 0) + 1
        }
    }

    return counts.map { it.value }
        .map { it * (it - 1) / 2 }
        .reduce(Int::plus)
}

fun main(args: Array<String>) {

    val queries = readLine().orEmpty().trim().toInt()

    for (q in 0 until queries) {

        val word = readLine().orEmpty()
        val result = sherlockAndAnagrams(word)
        println(result)
    }
}