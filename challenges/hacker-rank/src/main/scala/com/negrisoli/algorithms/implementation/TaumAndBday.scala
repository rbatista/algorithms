/* https://www.hackerrank.com/challenges/taum-and-bday */
package com.negrisoli.algorithms.implementation

object TaumAndBday {
  
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt
    
    (0 until t) foreach { ti =>
      val List(b, w, x, y, z) = ((0 to 4) map (i => sc.nextLong)).toList
      println(calcTheGifts(b, w, x, y, z))
    }
  }

  def calcTheGifts(b: Long, w: Long, x: Long, y: Long, z: Long) = 
    math.min(x, y + z) * b + math.min(y, x + z) * w

}