/**
 * https://www.hackerrank.com/challenges/frequency-queries/problem
 */
package com.raphaelnegrisoli.hackerrank.hashmaps

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val q = reader.readLine()!!.trim().toInt()

    val frequency : MutableMap<Int, Int> = HashMap(1000000)
    val dataByOccurrence : MutableMap<Int, Int> = HashMap(1000000)

    val builder = StringBuilder()
    for (i in 0 until q) {

        val (op, data) = reader.readLine()!!.trim().split(" ").map { it.toInt() }

        when (op) {
            1 -> {

                val f = frequency[data] ?: 0
                frequency[data] = f + 1
                dataByOccurrence[f] = if ((dataByOccurrence[f] ?: 0) > 0) dataByOccurrence[f]!! - 1 else 0
                dataByOccurrence[f + 1] = (dataByOccurrence[f + 1] ?: 0) + 1
            }
            2 -> {

                val f = frequency[data] ?: 0
                frequency[data] = if (f > 0) f - 1 else 0

                dataByOccurrence[f] = if ((dataByOccurrence[f] ?: 0) > 0) dataByOccurrence[f]!! - 1 else 0
                if (f > 0) {

                    dataByOccurrence[f - 1] = (dataByOccurrence[f - 1] ?: 0) + 1
                }
            }
            3 -> {

                val r = if ((dataByOccurrence[data] ?: 0) > 0) 1 else 0
                builder.append(r).append("\n")
            }
        }
    }

    println(builder.toString())
}