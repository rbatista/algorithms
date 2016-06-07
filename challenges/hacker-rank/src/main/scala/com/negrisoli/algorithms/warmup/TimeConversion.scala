package com.negrisoli.algorithms.warmup

object TimeConversion {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    var time = sc.next();
    
    val format = time.substring(8)
		val hour = time.substring(0, 2).toInt
		
		val mod = if (format == "PM" && hour != 12 || format == "AM" && hour == 12) 12 else 0 
		val hour24 = (hour + mod) % 24
		
		printf("%02d%s", hour24, time.substring(2, 8))
  }
}