package com.negrisoli.algorithms.warmup

object SimpleArraySum {
  def main(args: Array[String]) {
    var it = io.Source.stdin.getLines()
    var size = it.next().toInt
    println(it.next().split(" ").take(size).map(_.toInt).sum)
  }
  
}