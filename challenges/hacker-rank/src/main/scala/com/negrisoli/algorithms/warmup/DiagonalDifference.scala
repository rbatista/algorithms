package com.negrisoli.algorithms.warmup

object DiagonalDifference {
  def main(args:Array[String]) {
    val lines = io.Source.stdin.getLines()
    val size = lines.next().toInt
    val matrix = lines.take(size).map(_.split(" ")).map(_.map(_.toInt)).toArray
    
    var primary = 0
    var secondary = 0
    for (i <- (0 to size - 1)) {
      primary += matrix(i)(i)
      secondary += matrix(i)(size - (i+1))
    }
    
    println(Math.abs(primary - secondary))
  }
}