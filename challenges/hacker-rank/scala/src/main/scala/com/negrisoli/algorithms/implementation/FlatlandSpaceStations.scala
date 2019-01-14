/* https://www.hackerrank.com/challenges/flatland-space-stations */
package com.negrisoli.algorithms.implementation

object FlatlandSpaceStations {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val List(n, m) = ((0 to 1) map (i => sc.nextInt)).toList
    val stations = ((0 to m - 1) map (i => sc.nextInt)).toList
    
    print(calculateDistance(n, stations))
  }

  def calculateDistance(n: Int, unsortedStations: List[Int]): Int = {
    val stations = unsortedStations.sorted
    
    val first = stations(0)
    val middle = stations.sliding(2).map { x => x match {
      case x :: y :: xs => (y - x) / 2
      case _ => 0 
    }}.max
    val last = (n - 1) - stations.last
  
    List(first, middle, last).max
  }
  
}