/**
 * https://www.hackerrank.com/challenges/funny-string
 */
package com.negrisoli.algorithms.strings

import scala.util.control.Breaks

object FunnyString {
  
  def isFunny(str: List[Char]): Boolean = {
    
    for (i <- 1 to (str.size / 2)) {
      if (math.abs(str(i).toInt - str(i - 1)) != math.abs(str(str.size - i).toInt - str(str.size - i - 1))) {
        return false;
      }
    }
    
    return true;
  }
  
  def main(args: Array[String]): Unit = {
    
    val sc = new java.util.Scanner(System.in);
    val tests = sc.nextLine().toInt
    
    for (t <- 0 until tests) {
      if (isFunny(sc.nextLine().toList)) println("Funny") 
      else println("Not Funny")
    }
    
  }
}