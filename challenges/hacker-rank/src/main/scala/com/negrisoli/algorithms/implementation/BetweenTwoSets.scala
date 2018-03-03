/**
 * https://www.hackerrank.com/challenges/between-two-sets?h_r=internal-search
 */
package com.negrisoli.algorithms.implementation

object BetweenTwoSets {
  
      def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        val List(n, m) = ((0 to 1) map (i => sc.nextInt)).toList
        
        val A = ((0 until n) map (i => sc.nextInt)).toList
        val B = ((0 until m) map (i => sc.nextInt)).toList
        
        def gcd(a: Int, b: Int): Int =
            if (b == 0) a
            else gcd(b, a % b)

        def lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
        
        def listLcm(A: List[Int]): Int = 
            if (A.size == 1)  A.head
            else lcm(A.head, listLcm(A.tail))

        val x = listLcm(A)

        println ((1 to B(0) / x).map(i => B.map(_ % (x * i) )).filter(!_.exists(_ != 0)).size)
    }
  
}