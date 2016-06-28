package com.negrisoli.algorithms.implementation


object CavityMap {
  type Matrix = Array[Array[Int]]

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextLine().toInt
    val mat = Array.range(0, n).map( i => sc.nextLine().sliding(1).map(_.toInt).toArray )
    
    printMap(mat)
  }
  
  def printMap(mat:Matrix) {
    val n = mat.size
    for (i <- 0 to n - 1) {
      for (j <- 0 to n - 1) {
        if (!isBorder(i, j, n) && isDeeperThanNeightboors(i, j, mat)) print("X")
        else print(mat(i)(j))
      }
      println();
    }
  }
  
  def isBorder(i: Int, j: Int, n: Int) = 
    ((i == 0 || i == n-1) || (j == 0 || j == n - 1))
  
  def isDeeperThanNeightboors(i: Int, j: Int, mat: Matrix) = {
    (mat(i)(j) > mat(i - 1)(j)) && (mat(i)(j) > mat(i + 1)(j)) &&
       (mat(i)(j) > mat(i)(j - 1)) && (mat(i)(j) > mat(i)(j + 1))
  }
}