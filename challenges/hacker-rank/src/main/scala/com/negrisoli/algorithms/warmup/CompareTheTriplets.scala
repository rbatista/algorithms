/* https://www.hackerrank.com/challenges/compare-the-triplets */
package com.negrisoli.algorithms.warmup

object CompareTheTriplets {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val a = (0 to 2).map(i => sc.nextInt).toList
    val b = (0 to 2).map(i => sc.nextInt).toList

    println(calculateScore(a, b).productIterator.toList.mkString(" "))
  }

  def calculateScore(a: List[Int], b: List[Int]): (Int, Int) = {
    ((a zip b) foldLeft (0, 0)) {
      case ((accA, accB), (a, b)) if (a > b) => (accA + 1, accB)
      case ((accA, accB), (a, b)) if (b > a) => (accA, accB + 1)
      case ((accA, accB), (a, b))            => (accA, accB)
    }
  }

}