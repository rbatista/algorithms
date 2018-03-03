/* https://www.hackerrank.com/challenges/circular-array-rotation */
package com.negrisoli.algorithms.warmup

object CircularArrayRotation {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, k, q) = (0 to 2).map(i => sc.nextInt).toList
    val a = (1 to n).map(i => sc.nextInt).toList
    
    (1 to q) foreach { i =>
      val m = sc.nextInt
      println(query(a, k % n, m))
    }
  }
  
  def query(array: List[Int], rotate: Int, index: Int) = {
    array((array.size - rotate + index) % array.size)
  } 

}