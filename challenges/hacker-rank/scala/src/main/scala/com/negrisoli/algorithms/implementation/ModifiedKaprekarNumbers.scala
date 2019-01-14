package com.negrisoli.algorithms.implementation

object ModifiedKaprekarNumbers {
  
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val List(p, q) = ((0 to 1) map (i => sc.nextInt)).toList
    
    val solution = findKaprekar(p, q).toList match {
      case Nil => "INVALID RANGE"
      case xs => xs mkString " "
    }

    println(solution)
  }
  
  def findKaprekar(start: Int, end: Int) = {
    (start to end) map (_.toLong) filter { n =>
      val d = n.toString().length()
      val s = "0" + (n * n).toString
      val (l, r) = s.splitAt(s.size - d)
      l.toLong + r.toLong == n
    }
  }

}