/* https://www.hackerrank.com/challenges/bigger-is-greater */
package com.negrisoli.algorithms.implementation

object BiggerIsGreater {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextLine.trim.toInt
    
    (0 until t) foreach { ti =>
      val w = sc.nextLine
      println(solve(w))
    }
  }

  def solve(w: String) = {
    def removeAt(w: String, i: Int) = w.take(i) + w.drop(i + 1)
    
    def minIndex(w: String) = w.zipWithIndex.sortBy(_._1).map(_._2).head
    
    def minChar(w: String) = w(minIndex(w))
    
    def removeMin(w: String) = removeAt(w, minIndex(w))
    
    def swap(i: Int, j: Int) = {
      val prefix = w.take(j)
      val sufix = w.drop(j)
      // prefix + minChar(sufix) + removeMin(w.drop(j)).sorted
      prefix + w(i) + removeAt(sufix, i - j).sorted
    }
    
    def findBigger(i: Int, j: Int): String = {
      if (i < 1 && j < 0) "no answer"
      // else if (j < 0) findBigger(i - 1, i - 2)
      else if (w(i) > w(j)) swap(i, j)
      else findBigger(i - 1, j - 1)
    }
    
    findBigger(w.size - 1, w.size - 2)
  }
}