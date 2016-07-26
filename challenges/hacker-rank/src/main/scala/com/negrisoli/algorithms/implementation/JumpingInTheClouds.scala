/* https://www.hackerrank.com/challenges/jumping-on-the-clouds */
package com.negrisoli.algorithms.implementation

object JumpingInTheClouds {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val clouds = (1 to n) map (i => sc.nextInt) toList
    
    println(min(clouds))
  }

  def min(clouds: List[Int]): Int =  {
    def jump(acc: Int, clouds: List[Int]): Int = clouds match {
      case List() => acc
      case _ :: 0 :: xs => jump(acc + 1, xs)
      case 0 :: 1 :: xs => jump(acc + 2, xs.tail)
      case _ :: xs => acc + 1
    }
  
    jump(0, clouds.tail)
  }
}