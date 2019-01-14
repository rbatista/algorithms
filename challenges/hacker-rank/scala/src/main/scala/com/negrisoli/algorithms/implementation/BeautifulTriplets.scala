package com.negrisoli.algorithms.implementation

object BeautifulTriplets {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, d) = ((0 to 1) map (i => sc.nextInt)).toList
    val a = ((0 to n - 1) map (i => sc.nextInt)).toList

    println(resolve(a, d))
  }

  def resolve(a: List[Int], d: Int) = {
    def getFirst(idx: Int) =
      if (idx >= a.size) -1
      else a indexWhere ( _ >= a(idx) + d, idx + 1)
  
    (for {
      i <- (0 until a.size - 2)
      j = getFirst(i)
      if j >= 0 && a(j) == a(i) + d
      k = getFirst(j)
      if k >= 0 && a(k) == a(j) + d
    } yield 1).size
  }
}