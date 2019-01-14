/* https://www.hackerrank.com/challenges/cut-the-sticks */
package com.negrisoli.algorithms.implementation

object CutTheSticks {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val size = sc.nextInt();

    cut((0 to size-1).map(i => sc.nextInt()).toList)
  }
  
  def cut(args:List[Int]) {
    def iter(args:List[Int]) {
      if (!args.isEmpty) {
        println(args.size)
        iter(args.map(_ - args.min).filter(_ > 0))
      }
    }
    
    iter(args)
  }
}