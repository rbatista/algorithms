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
    val l = Array.fill(size - 1)(a)

    var sums = new scala.collection.mutable.ListBuffer[Int]
    sums += l.sum
    for (i <- 0 to l.size - 1) {
      l(l.size - 1 - i) = b
      sums += l.sum
    }
    
    sums.toArray
  }

}