package com.negrisoli.algorithms.implementation

object DivisibleSumPairs {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, k) = readSeq(() => sc.nextInt, 2)
    val array = readSeq(() => sc.nextInt, n)
    
    println(count(array, k))
  }
  
  def readSeq[T](read: () => T, n:Int): List[T] = 0.to(n - 1).map(x => read() ).toList

  def count(array: List[Int], k: Int): Int = {
    def isDivisible(x: Int, y:Int) = (x + y) % k == 0
    
    def iter(array: List[Int]): Int = array match {
      case y0 :: y1 :: tl => (if (isDivisible(y0, y1)) 1 else 0) + iter(y0 :: tl)
      case y => 0
    }
    
    array match {
      case y0 :: tl => if (tl.isEmpty) 0 else iter(y0 :: tl) + count(tl, k)
      case y => 0 
    }
  }
  // (0 until n).flatMap { i => (i + 1 until n).map {j => if ((a(i) + a(j)) % k == 0) 1 else 0 } }.sum

}