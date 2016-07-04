package com.negrisoli.algorithms.implementation

import java.math.BigInteger

object AcmIcpcTeam {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    
    val topics = 1.to(n).map(x => sc.next() ).map( new BigInteger(_, 2)).toArray

    var max = 0
    var pairs = 0
    for (i <- 0 to topics.size - 1) { 
      for (j <- i + 1 to topics.size - 1) {
        val c = count(topics(i), topics(j))
        if (c > max) {
          max = c
          pairs = 1
        } else if (c == max && pairs > 0) {
          pairs = pairs + 1
        }
      }
    }
    
    println(max)
    println(pairs)
  }
  
  def count(x: BigInteger, y:BigInteger): Int = x.or(y).bitCount()

}