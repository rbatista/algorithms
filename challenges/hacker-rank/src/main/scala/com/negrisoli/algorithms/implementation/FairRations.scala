/* https://www.hackerrank.com/challenges/fair-rations */
package com.negrisoli.algorithms.implementation

object FairRations {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val line = ((1 to n) map (i => sc.nextInt)).toList

    println(calcRations(line).getOrElse("NO"))
  }
  
  def calcRations(xs: List[Int]): Option[Int] = {
    val ys = xs.zipWithIndex filter (_._1 % 2 != 0)
    if (ys.size % 2 == 1) None
    else Some((ys map (_._2) grouped (2) map {
      case List(x, y) => y - x
    }).sum * 2)
  }

}