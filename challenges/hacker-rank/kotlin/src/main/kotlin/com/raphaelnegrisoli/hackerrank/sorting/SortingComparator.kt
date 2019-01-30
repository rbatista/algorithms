/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 */
package com.raphaelnegrisoli.hackerrank.sorting

data class Player(val name: String, val score: Int)

fun main(args: Array<String>) {

    val n = readLine()!!.trim().toInt()

    val players = arrayListOf<Player>()
    for (i in 0 until n) {

        val (name, score) = readLine()!!.trim().split(" ")
        players.add(Player(name, score.toInt()))
    }

    players.sortWith(Comparator { p1, p2 ->
        when {
            p1.score < p2.score -> 1
            p1.score > p2.score -> -1
            else -> p1.name.compareTo(p2.name)
        }
    })

    println(players.joinToString(separator = "\n") { p -> "${p.name} ${p.score}" })
}
