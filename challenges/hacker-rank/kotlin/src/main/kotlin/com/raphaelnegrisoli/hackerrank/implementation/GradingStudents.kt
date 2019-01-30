/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
package com.raphaelnegrisoli.hackerrank.implementation

import java.util.*

fun gradingStudents(grades: Array<Int>): Array<Int> {
    /*
     * Write your code here.
     */
    return grades.map { n ->
        if (n < 38) n
        else if (n % 5 >= 3) n + 5 - n % 5
        else n
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val grades = Array(n) { 0 }
    for (gradesItr in 0 until n) {
        val gradesItem = scan.nextLine().trim().toInt()
        grades[gradesItr] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}