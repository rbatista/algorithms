package com.negrisoli.algorithms.implementation

object LibraryFine {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    val returnDate = sc.nextLine().split(" ").map(_.toInt)
    val dueDate = sc.nextLine().split(" ").map(_.toInt)

    println(calculateFine(diff(dueDate, returnDate)))
  }
  
  def diff(d1: Array[Int], d2: Array[Int]):Array[Int] = {
    Array(d2(0) - d1(0), d2(1) - d1(1), d2(2) - d1(2))
  }
  
  def calculateFine(d: Array[Int]): Int = {
    def apply(diff:Array[Int], p:Array[Int => Int]):Int = {
      if (diff.isEmpty) 0
      else if (diff.head > 0) p.head(diff.head)
      else if (diff.head < 0) 0
      else apply(diff.tail, p.tail)
    }
    
    apply(d.reverse, Array(x => 10000, x => x * 500, x => x * 15))
  }
    
}