/* https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited */
package com.negrisoli.algorithms.implementation

object JumpingInTheCloudsRevisited {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, k) = ((0 to 1) map (i => sc.nextInt)).toList
    val clouds = ((0 to n-1) map (i => sc.nextInt)).toList
    
    println(calcEnergy(k, clouds))
  }

  def calcEnergy(k: Int, clouds: List[Int]): Int = {
    100 - (((0 to clouds.size - 1 by k) count (i => clouds(i) == 1)) * 2 + clouds.size / k)
  }
}