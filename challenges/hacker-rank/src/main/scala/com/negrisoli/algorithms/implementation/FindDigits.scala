/* https://www.hackerrank.com/challenges/find-digits */
package com.negrisoli.algorithms.implementation;

object FindDigits {

    def main(args:Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val nTests = sc.nextInt
        
        for (i <- 0 to nTests - 1) {
            val n = sc.nextInt
            println(countDivisor(n))
        }
    }

    def countDivisor(n:Int): Int = {
        val digits = scala.collection.mutable.ArrayBuffer.empty[Int]
        
        var number = n
        while (number > 0) {
            digits += number % 10
            number = number / 10
        }
        
        return digits.filter( _ > 0).count(n % _ == 0)
    }

}
