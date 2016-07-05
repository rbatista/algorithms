package com.negrisoli.algorithms.warmup

object SaveThePrisoner {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt()
    
    for (i <- 0 to t - 1) {
    	val List(prisioners, sweets, start) = 0.to(2).map( x => sc.nextInt() ).toList
      println(calculateSweet(prisioners, sweets, start))
    }
    
  }
  
  def calculateSweet(n:Int, m:Int, s:Int) = rotate(m + s - 2, n)
  
  def rotate(c: Int, n: Int) = c % n + 1
}