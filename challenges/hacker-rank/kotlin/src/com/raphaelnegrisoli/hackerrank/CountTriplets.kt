package com.raphaelnegrisoli.hackerrank

import java.math.BigInteger


fun countTriplets(arr: List<Long>, ratio: Long): BigInteger {

    val singlets = mutableMapOf<Long, BigInteger>()
    val doublets = mutableMapOf<Pair<Long, Long>, BigInteger>()

    var triplets = BigInteger.ZERO
    for (i in arr) {

        println("i=$i")

        val previous = i / ratio
        val previousDoublet = (previous / ratio) to previous
        println(previousDoublet)
        if ((doublets[previousDoublet] ?: BigInteger.ZERO) > BigInteger.ZERO) {

            val value = doublets[previousDoublet]!!
            println("plus ${value} to triplet (${previousDoublet.first}, ${previousDoublet.second}, $i) ")
            triplets += value
        }

        val previousValue = singlets[previous] ?: BigInteger.ZERO
        if (previousValue > BigInteger.ZERO) {

            val doublet = previous to i
            val value = (doublets[doublet] ?: BigInteger.ZERO) + previousValue
            println("Update doublet $doublet = $value")
            doublets[doublet] = value
        }

        val value = (singlets[i] ?: BigInteger.ZERO) + BigInteger.ONE
        println("Update singlet $i = $value")
        singlets[i] = value

        println(singlets)
        println(doublets)
        println()
    }

    println(triplets)

    return triplets
}

fun main(args: Array<String>) {

//    val (_, ratio) = readLine().orEmpty().trim()
//        .split(" ")
//        .map { it.toLong() }
//    val arr = readLine().orEmpty().trim()
//        .split(" ")
//        .map { it.toLong() }

    for (i in listOf(Triple(listOf<Long>(1, 2, 1, 2, 4), 2L, 3),
        Triple(listOf<Long>(1, 2, 4, 1, 2), 2L, 1),
        Triple(listOf<Long>(1, 1, 1), 1L, 1))) {

        println(countTriplets(i.first, i.second).toInt() == i.third)
    }
    //val result = countTriplets(arr, ratio)
//    val result = countTriplets(arr, ratio)
    //println(result)
}