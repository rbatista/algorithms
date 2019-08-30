/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */
package com.raphaelnegrisoli.hackerrank.trees

import kotlin.math.max

data class Node(
        val data: Int,
        var left: Node? = null,
        var right: Node? = null
) {

    fun insert(data: Int) {
        if (data < this.data) {
            if (left == null ) left = Node(data)
            else left?.insert(data)
        } else if (data > this.data) {
            if (right == null) right = Node(data)
            else right?.insert(data)
        }
    }

    fun height(current: Int = 0): Int {

        val leftHeight = left?.height(current + 1) ?: current
        val rightHeight = right?.height(current + 1) ?: current

        return max(leftHeight, rightHeight)
    }

}

fun main() {
    readLine()
    val data = readLine()
            ?.split(" ")
            ?.map { it.toInt() }
            ?: emptyList()

    val root = Node(data.first())
    data.drop(1).forEach { root.insert(it) }

    println(root.height())
}
