/* https://www.hackerrank.com/challenges/kangaroo */
package com.negrisoli.algorithms.implementation

object Kangaroo {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(l0, r0, l1, r1) = 0.to(3).map( x => sc.nextInt() ).map(_.toInt).toList
    
    if (!isPossible(l0, r0, l1, r1) || !landTogether(l0, r0, l1, r1)) println("NO")
    else println("YES") 
  }
  
  def isPossible(l0 : Int, r0:Int, l1: Int, r1: Int) = {
    l0 < l1 && r0 > r1 || l1 < l0 && r1 > r0 || l0 == l1
  }
  
  def landTogether(l0: Int, r0: Int, l1: Int, r1: Int): Boolean = {
    math.abs(l0 - l1) % math.abs(r0 - r1) == 0
  }

}