package com.negrisoli.algorithms.warmup

object PlusMinus {
  
  def main(args:Array[String]) {
    val lines = io.Source.stdin.getLines()
    val size = lines.next().toInt
    
    val array = lines.next().split(" ").take(size).map(_.toInt).groupBy(_.compareTo(0)).mapValues(_.size.toFloat / size).withDefaultValue(0.0f)    
    println(f"${array(1)}%1.5f")
    println(f"${array(-1)}%1.5f")
    println(f"${array(0)}%1.5f")
  }
  
}