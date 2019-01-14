/* https://www.hackerrank.com/challenges/sherlock-and-squares */
package com.negrisoli.algorithms.implementation

object SherlockAndSquares {
  
  def main(args:Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val nTests = sc.nextInt()
    
    for (i <- 0 to nTests-1) {
      val begin = sc.nextInt()
      val end = sc.nextInt()
      
      val i =  math.sqrt(begin).ceil.toInt
      val j =  math.sqrt(end).floor.toInt
      printf("%d\n", j - i + 1)
    }
  }

}