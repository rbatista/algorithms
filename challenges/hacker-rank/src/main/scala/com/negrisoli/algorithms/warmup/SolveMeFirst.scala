/* https://www.hackerrank.com/challenges/solve-me-first */
package com.negrisoli.algorithms.warmup

import io.Source.stdin

object SolveMeFirst {
  def main(args: Array[String]) {
    println(stdin.getLines().take(2).map(_.toInt).sum)
  }
}