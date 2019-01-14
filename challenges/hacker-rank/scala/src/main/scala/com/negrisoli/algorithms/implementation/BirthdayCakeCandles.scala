/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles
 */
package com.negrisoli.algorithms.implementation

object BirthdayCakeCandles {
  
  def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in);
        val n = sc.nextInt
        
        val candles = ((0 until n) map (i => sc.nextInt)).toList
        
        val max = candles.max
        print(candles.filter(_ == max).size)
        
    }
  
}