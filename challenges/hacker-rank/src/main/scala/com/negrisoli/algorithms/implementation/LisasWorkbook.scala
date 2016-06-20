package com.negrisoli.algorithms.implementation

object LisasWorkbook {
  
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val size = sc.nextInt
    val perPage = sc.nextInt
    val problems = List.tabulate(size)(n => sc.nextInt)
    
    println(countSpecials(perPage, problems))
  }
  
  def page(problems:Int, size:Int) = problems / size + (if (problems % size > 0) 1 else 0)
  
  def countSpecials(perPage:Int, problems:List[Int]):Int = {
    val pages = problems.map(page(_, perPage)).sum
    
    val book = (0 to problems.size -1).flatMap(i =>
       (1 to problems(i)).toList.sliding(perPage,perPage).toList
     ).toList
  
     (1 to pages).count(i => book(i-1).contains(i)) 
  }
  
}