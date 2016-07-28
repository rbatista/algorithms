/* https://www.hackerrank.com/challenges/fair-rations */
package com.negrisoli.algorithms.implementation

object FairRations {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val line = ((1 to n) map (i => sc.nextInt)).toList

    println(distributeRations(line))
  }

  def distributeRations(line: List[Int]): String = {
    def resolve: Int = {
      val xs = line map { _ % 2 }
      val sum = xs.sum
      if (sum == 0) 0
      else if (sum % 2 == 1) -1
      else calcRations(xs)
    }

    resolve match {
      case x if x >= 0 => x.toString()
      case _           => "NO"
    }
  }

  def calcRations(xs: List[Int]) = {
    (xs.zipWithIndex.map {
        case (v, i) =>
          if (v == 0) -1
          else i
      } filter (_ != -1) sliding (2, 2) map {
        case List(x, y) => y - x
      }).sum * 2
  }
}