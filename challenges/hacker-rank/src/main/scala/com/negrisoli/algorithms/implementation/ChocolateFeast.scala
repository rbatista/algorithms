package com.negrisoli.algorithms.implementation

object ChocolateFeast {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);
    val tests = sc.nextInt
    for (i <- 0 to tests - 1) {
      val n = sc.nextInt
      val c = sc.nextInt
      val m = sc.nextInt

      println(calc(n, c, m))
    }
  }

  def calc(n: Int, c: Int, m: Int): Int = {
    def iter(x: Int): Int = if (x < m) 0 else x / m + iter(x / m + x % m)

    n / c + iter(n / c)
  }

} 