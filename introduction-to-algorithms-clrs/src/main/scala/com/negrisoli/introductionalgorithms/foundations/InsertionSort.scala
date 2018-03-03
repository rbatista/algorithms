package com.negrisoli.introductionalgorithms.foundations

/**
 * Runtime complexity: n^2
 */
object InsertionSort {
  
  def sort(array : Array[Int]): Array[Int] = {
    
    for (j <- 1 to array.size - 1) {
      
    	val key = array(j)
      var i = j - 1
      while (i >= 0 && array(i) > key) {
        
        array(i + 1) = array(i)
        i = i - 1
      }
    	
    	array(i + 1) = key
    }
    
    array
  }
  
  /**
   * Functional version of the Insertion Sort
   */
  def sortF(list: List[Int]): List[Int] = {
    
    def insert(sorted: List[Int], value: Int): List[Int] = {
      
      if (sorted.isEmpty) List(value)
      else if (sorted.head > value) value :: sorted 
      else sorted.head :: insert(sorted.tail, value)
    }
    
    def next(sorted: List[Int], unsorted: List[Int]): List[Int] = {
      
      if (unsorted.isEmpty) sorted
      else next(insert(sorted, unsorted.head), unsorted.tail)
    }
    
    if (list.size <= 1) list
    else next(List(), list)
  }
  
}