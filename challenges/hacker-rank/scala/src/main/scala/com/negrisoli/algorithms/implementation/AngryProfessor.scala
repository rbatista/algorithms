/* https://www.hackerrank.com/challenges/angry-professor */
package com.negrisoli.algorithms.implementation

object AngryProfessor {
  
  def main(args:Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val nTestCases = sc.nextInt()
    
    for (i <- 0 to nTestCases-1) {
      val nStudents = sc.nextInt()
      val threshold = sc.nextInt()
      val inTime = (0 to nStudents-1).map(i => sc.nextInt()).count(_ <= 0)
      
      println(if (inTime < threshold) "YES" else "NO")
    }
  }
}