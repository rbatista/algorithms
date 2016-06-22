package com.negrisoli.algorithms.implementation

object TheGridSearch {
  
  type Row = Array[Int]
  type Matrix = Array[Row]
  
  def readMatrix(rows: Int, cols: Int, p:() => String ): Matrix = {
    p() // clean \n
    Array.range(0, rows).map(r => lineToArray(p()))
  }
  
  def lineToArray(s:String): Row = {
    s.sliding(1, 1).map(_.toInt).toArray
  }
  
  def indexOffAll(line:Row, pattern:Row) = {
    val arr = scala.collection.mutable.ArrayBuffer.empty[Int]
    
    def iter(acc:Array[Int], pos: Int, patPos: Int): scala.collection.mutable.ArrayBuffer[Int] =
      if (line.size - pos < pattern.size - patPos) arr
      else if (patPos >= pattern.size) arr += (pos - pattern.size) 
      else if (line(pos) == pattern(patPos)) {
        iter(acc, pos + 1, patPos + 1)
        iter(acc, pos + 1, patPos)
        arr
      }
      else iter(acc, pos + 1, 0)
   
    iter(Array[Int](), 0, 0).toArray
  }
  
  def matchPattern(matrix:Matrix, pattern:Matrix):Boolean = {
    def isPatternAt(mRow:Int, pRow:Int, cIndex:Int):Boolean = {
      if (pRow >= pattern.size) return true
      else if (mRow >= matrix.size) return false
      
      val lineMatch = indexOffAll(matrix(mRow), pattern(pRow))
      if (lineMatch.contains(cIndex)) isPatternAt(mRow + 1, pRow + 1, cIndex)
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