/**
 * https://www.hackerrank.com/challenges/balanced-brackets
 */
package com.raphaelnegrisoli.hackerrank

val closePairs = mapOf(']' to '[',
    '}' to '{',
    ')' to '(')
val open = setOf('[', '{', '(')

fun main(args: Array<String>) {

    val n = readLine().orEmpty().toInt()

    for (i in 0 until n) {

        val line = readLine().orEmpty()
        println(isBalanced(line))
    }
}

tailrec fun isBalanced(remainder: String, stack: List<Char> = listOf()): String {

    return when {
        remainder.isEmpty() && stack.isEmpty() -> "YES"
        !remainder.isEmpty() && open.contains(remainder.first()) -> isBalanced(remainder.drop(1), listOf(remainder.first()) + stack)
        !stack.isEmpty() && !remainder.isEmpty() &&
                closePairs.contains(remainder.first()) && stack.first() == closePairs[remainder.first()] ->
            isBalanced(remainder.drop(1), stack.drop(1))
        else -> "NO"
    }
}
