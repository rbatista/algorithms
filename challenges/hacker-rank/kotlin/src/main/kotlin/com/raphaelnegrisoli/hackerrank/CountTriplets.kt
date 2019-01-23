/**
 * https://www.hackerrank.com/challenges/count-triplets-1/
 */
package com.raphaelnegrisoli.hackerrank

import java.math.BigInteger


fun countTriplets(arr: List<Long>, ratio: Long): BigInteger {

    val singlets = mutableMapOf<Long, BigInteger>()
    val doublets = mutableMapOf<Pair<Long, Long>, BigInteger>()

    var triplets = BigInteger.ZERO
    for (i in arr) {

        if (i % ratio == 0L) {
            val previous = i / ratio

            val previousDoublet = (previous / ratio) to previous
            if ((doublets[previousDoublet] ?: BigInteger.ZERO) > BigInteger.ZERO) {

                triplets += doublets[previousDoublet]!!
            }

            val previousValue = singlets[previous] ?: BigInteger.ZERO
            if (previousValue > BigInteger.ZERO) {

                val doublet = previous to i
                doublets[doublet] = (doublets[doublet] ?: BigInteger.ZERO) + previousValue
            }
        }

        singlets[i] = (singlets[i] ?: BigInteger.ZERO) + BigInteger.ONE
    }

    return triplets
}

fun main(args: Array<String>) {

    val (_, ratio) = readLine().orEmpty().trim()
        .split(" ")
        .map { it.toLong() }
    val arr = readLine().orEmpty().trim()
        .split(" ")
        .map { it.toLong() }


    val result = countTriplets(arr, ratio)
    println(result)
}
