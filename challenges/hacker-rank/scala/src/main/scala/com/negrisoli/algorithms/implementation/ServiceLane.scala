/* https://www.hackerrank.com/challenges/service-lane */
package com.negrisoli.algorithms.implementation

object ServiceLane {
  
  def main(args:Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val size = sc.nextInt();
    val nTests = sc.nextInt();
    
    val freeway = (0 to size-1).map(i => sc.nextInt())
    for (i <- (0 to nTests)) {
      val enter = sc.nextInt()
      val exit = sc.nextInt()
      
      println(freeway.slice(enter, exit + 1).min)
    }
  }
}