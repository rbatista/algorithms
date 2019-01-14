/**
 * https://www.hackerrank.com/challenges/the-hurdle-race
 */
package com.negrisoli.algorithms.implementation

object TheHurdleRace {
  
  def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        val List(n, k) = ((0 to 1).map(i => sc.nextInt)).toList
        val hs = ((0 until n).map(i => sc.nextInt)).toList
        
        val max = hs.max
        print(if (k > max) 0 else max - k)
    }
  
}