/**
 * https://www.hackerrank.com/challenges/2d-array
 */
package com.negrisoli.algorithms.datastructures

object Array2D {
  
  def sum(mat: Seq[Seq[Int]], i: Int, j: Int) = {
    mat(i)(j) + mat(i)(j + 1) + mat(i)(j + 2) + 
      mat(i + 1)(j + 1) + 
      mat(i + 2)(j) + mat(i + 2)(j + 1) + mat(i + 2)(j + 2)
  }
    
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val mat = (0 to 5).map(i => (0 to 5).map(j => sc.nextInt()))
    println((0 to 3).flatMap(i => (0 to 3).map(j => sum(mat, i, j))).max)
  }
    
}