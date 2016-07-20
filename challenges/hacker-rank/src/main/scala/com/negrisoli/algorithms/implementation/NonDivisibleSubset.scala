package com.negrisoli.algorithms.implementation

object NonDivisibleSubset {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, k) = readSeq(() => sc.nextInt, 2)
    val array = readSeq(() => sc.nextInt, n)

    println(count(array, k))
  }

  def readSeq[T](read: () => T, n: Int): List[T] = 0.to(n - 1).map(x => read()).toList

  def count(s: List[Int], k: Int): Int = {
    val counts = s map { _ % k } groupBy { identity } mapValues { _.size } withDefaultValue 0

    ((0 until k / 2 + 1) map { i => i match {
      case 0               => if (counts.contains(0)) 1 else 0
      case x if x * 2 == k => if (counts.contains(k / 2)) 1 else 0
      case x               => math.max(counts(x), counts(k - x))
    }}).sum
  }

}