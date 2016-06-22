package com.negrisoli.algorithms.implementation

import scala.collection.mutable.ListBuffer

object TheGridSearch {
  
  type Row = String
  type Matrix = List[String]
  
  def readMatrix(rows: Int, cols: Int, p:() => String ): Matrix = {
    p() // clean \n
    List.range(0, rows).map(r => p())
  }
  
  def indexOffAll(line:Row, pattern:Row): List[Int] = {
    val buf = new ListBuffer[Int]
    var i = 0
    while (i >= 0) {
      i = line.indexOf(pattern, i)
      if (i != -1) {
        buf += i
        i += 1
      }
    }
    
    buf.toList
  }
  
  def matchPattern(matrix:Matrix, pattern:Matrix):Boolean = {
    def isPatternAt(mRow:Int, pRow:Int, cIndex:Int):Boolean = {
      if (pRow >= pattern.size) return true
      else if (mRow >= matrix.size) return false
      
      if (matrix(mRow).slice(cIndex, cIndex + pattern(pRow).size) == pattern(pRow)) isPatternAt(mRow + 1, pRow + 1, cIndex)
      else false
    }
    
    for (i <- 0 to matrix.size-1) {
      val lineMatches = indexOffAll(matrix(i), pattern(0));
      for (j <- lineMatches) {
        if (isPatternAt(i + 1, 1, j)) return true
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    
    for (i <- List.range(0, sc.nextInt())) {
      val matrix = readMatrix(sc.nextInt(), sc.nextInt(), () => sc.nextLine())
      val pattern = readMatrix(sc.nextInt(), sc.nextInt(), () => sc.nextLine())
      
      println(if (matchPattern(matrix, pattern)) "YES" else "NO")
    }
  }
  
}