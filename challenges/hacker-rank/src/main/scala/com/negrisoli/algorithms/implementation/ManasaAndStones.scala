package com.negrisoli.algorithms.implementation

object ManasaAndStones {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val tests = sc.nextInt();
    
    for (i <- 0 to tests - 1) {
      val size = sc.nextInt()
      val a = sc.nextInt()
      val b = sc.nextInt()
      
      println(compose(a, b, size).distinct.sorted.mkString(" "))
    }
  }

  def compose(a: Int, b: Int, size: Int): Array[Int] = {
    def iter(acc:Array[Int], sum:Int, i:Int): Array[Int] = {
      if (i == size - 1) acc :+ sum
      else iter(acc, sum + a, i + 1) ++ iter(acc,  b + sum, i + 1)
    }
    
    iter(Array(), 0, 0)
  }
}