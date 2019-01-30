package com.raphaelnegrisoli.hackerrank.strings


fun main(args: Array<String>) {

    val q = readLine()!!.trim().toInt()

    for (i in 0 until q) {

        val str = readLine()?.trim() ?: ""

        var lastChar = if (str.isNotEmpty()) str[0] else ' '
        var deletions = 0
        for (char in str.drop(1)) {

            if (char == lastChar) {

                deletions++
            } else {

                lastChar = char
            }
        }

        println(deletions)
    }

}