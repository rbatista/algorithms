package com.negrisoli.algorithms.implementation

object TheGridSearch {
  
  def readMatrix(rows: Int, cols: Int, p:() => String ): Array[Array[Int]] = {
    p() // clean \n
    Array.range(0, rows).map(r => lineToArray(p()))
  }
  
  def lineToArray(s:String): Array[Int] = {
    s.sliding(1, 1).map(_.toInt).toArray
  }
  
  def indexOffAll(line:Array[Int], pattern:Array[Int]) = {
    def iter(acc:Array[Int], pos: Int, patPos: Int): Array[Int] =
      if (line.size - pos < pattern.size - patPos) acc
      else if (patPos >= pattern.size) acc ++ Array(pos - pattern.size) 
      else if (line(pos) == pattern(patPos)) iter(acc, pos + 1, patPos + 1) ++ iter(acc, pos + 1, patPos)
      else iter(acc, pos + 1, 0)
   
    iter(Array[Int](), 0, 0)
  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    
    for (i <- List.range(0, sc.nextInt())) {
      val matrix = readMatrix(sc.nextInt(), sc.nextInt(), () => sc.nextLine())
      val pattern = readMatrix(sc.nextInt(), sc.nextInt(), () => sc.nextLine())
      
      println("mat" + matrix(0))
      println("pat" + pattern(0))
    }
  }
  
}