/* https://www.hackerrank.com/challenges/sherlock-and-the-beast */
package com.negrisoli.algorithms.implementation

object SherlockandTheBeast {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val nCases = sc.nextInt();

    for (i <- (0 to nCases - 1)) {
      val digits = sc.nextInt()
      val x = findMaxDiv(digits)
      if ((digits - x) % 3 == 0) {
        println("5" * digits)
      } else if ((digits - x) % 5 == 0) {
        println("5" * x + "3" * (digits - x))
      } else {
        println(-1)
      }
    }
  }

  def findMaxDiv(digits: Int): Int = {
    for (i <- (digits to 3 by -5)) {
      if (i % 3 == 0) return i
    }

    return 0
  }

}