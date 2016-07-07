package com.negrisoli.algorithms.implementation

object EqualStacks {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n1, n2, n3) = 0.to(2).map( i => sc.nextInt() ).toList
    val s1 = 0.to(n1 - 1).map( i => sc.nextInt() ).toList
    val s2 = 0.to(n2 - 1).map( i => sc.nextInt() ).toList
    val s3 = 0.to(n3 - 1).map( i => sc.nextInt() ).toList
    
    val h1 = s1.sum
    val h2 = s2.sum
    val h3 = s3.sum
    
    println(resolve(s1, h1, s2, h2, s3, h3))
  }

  def resolve(s1: List[Int], h1: Int, s2: List[Int], h2: Int, s3: List[Int], h3:Int): Int = {
    if (h1 == h2 && h2 == h3) h1
    else if (h1 >= h2 && h1 >= h3) resolve(s1.tail, h1 - s1.head, s2, h2, s3, h3)
    else if (h2 >= h1 && h2 >= h3) resolve(s1, h1, s2.tail, h2 - s2.head, s3, h3)
    else resolve(s1, h1, s2, h2, s3.tail, h3 - s3.head)
  }
  
}