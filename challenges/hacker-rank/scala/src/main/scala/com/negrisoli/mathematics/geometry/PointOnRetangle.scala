/**
 * https://www.hackerrank.com/challenges/points-on-rectangle
 */
package com.negrisoli.mathematics.geometry

import scala.Vector

object PointOnRetangle {

  def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in);
        val queries = sc.nextInt
                
        for (i <- 1 to queries) {
            val pointsSize = sc.nextInt
            val points = (1 to pointsSize * 2).map(j => sc.nextInt).sliding(2, 2).toList
 

            val min = points.reduceLeft((x, y) => Vector(x(0) min y(0), x(1) min y(1)))
            val max = points.reduceLeft((x, y) => Vector(x(0) max y(0), x(1) max y(1)))
            
            val allPointsAreOnEdge = points.forall({ 
                x => (x(0) == min(0) || x(0) == max(0)) || (x(1) == min(1) || x(1) == max(1))
            })
            println(if (allPointsAreOnEdge) "YES" else "NO")
        }
  }

}