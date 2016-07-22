/* https://www.hackerrank.com/challenges/minimum-distances */
package com.negrisoli.algorithms.implementation

object MinimumDistances {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val size = sc.nextInt()
    val a = 0.to(size-1).map( x => sc.nextInt() ).toList
    
    println(findMin(a))
  }

  def findMin(a: List[Int]) = {
    def internalLoop(min: Int, x: (Int, Int), a: List[(Int, Int)]): Int = a match {
      case List() => min
      case y :: ys if (x._1 == y._1) =>
        val m = math.abs(x._2 - y._2);
        if (m < min || min < 0) internalLoop(m, x, ys)
        else internalLoop(min, x, ys)
      case y :: ys => internalLoop(min, x, ys)
    }
    
    def iter(min: Int, a: List[(Int, Int)]): Int = a match {
      case List() => min
      case y :: ys => iter(internalLoop(min, y, ys), ys)
    }
        
    iter(-1, a.zipWithIndex)
  }
}