package com.negrisoli.algorithms.warmup

object Staircase {
  
  def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        (1 to n).foreach(i => println(" " * (n-i) + "#" * i))
   }

}