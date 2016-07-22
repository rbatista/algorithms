package com.negrisoli.algorithms.warmup

object ChocolateFeast {
  
  
  val a = List(5, 6, 7)                           //> a  : List[Int] = List(5, 6, 7)
  val b = List(3, 6, 10)                          //> b  : List[Int] = List(3, 6, 10)
  
  (a zip b)                                       //> res0: List[(Int, Int)] = List((5,3), (6,6), (7,10))
  
  ((a zip b) foldLeft (0, 0)) {
    case ((accA, accB), (a, b)) if (a > b) => (accA + 1, accB)
    case ((accA, accB), (a, b)) if (b > a) => (accA, accB + 1)
    case ((accA, accB), (a, b)) => (accA, accB)
  }                                               //> res1: (Int, Int) = (1,1)
                                           
}