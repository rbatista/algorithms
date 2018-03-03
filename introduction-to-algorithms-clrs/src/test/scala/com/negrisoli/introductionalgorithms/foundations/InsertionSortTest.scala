package com.negrisoli.introductionalgorithms.foundations

import org.scalatest.FunSuite

class InsertionSortTest extends FunSuite {
  
  import InsertionSort._
  
  test("sort should do it in an desc array") {
    
    assert(sort(Array(7, 5, 2, 3, 1)) === Array(1, 2, 3, 5, 7))
  }
  
  test("sort should do it in an shuffled array") {
    
    assert(sort(Array(7, 3, 2, 5, 13, 1)) === Array(1, 2, 3, 5, 7, 13))
  }
  
  test("sort ordered array should be itself") {
    
    assert(sort(Array(1, 2, 3, 5, 7, 13)) === Array(1, 2, 3, 5, 7, 13))
  }
  
  test("sort equal elements should be itself") {
    
    assert(sort(Array(5, 5, 5)) === Array(5, 5, 5))
  }
  
  test("sort one element shold be itself") {
    
    assert(sort(Array(5)) === Array(5))
  }
  
  test("sort empty array shold be itself") {
    
    assert(sort(Array()) === Array())
  }
  
  test("sortF should do it in an totally desc array") {
    
    assert(sortF(List(7, 5, 2, 3, 1)) === List(1, 2, 3, 5, 7))
  }
  
  test("sortF should do it in an shuffled array") {
    
    assert(sortF(List(7, 3, 2, 5, 13, 1)) === List(1, 2, 3, 5, 7, 13))
  }
  
  test("sortF ordered list should be itself") {
    
    assert(sortF(List(1, 2, 3, 5, 7)) === List(1, 2, 3, 5, 7))
  }
  
  test("sortF equal elements should be itself") {
    
    assert(sortF(List(5, 5, 5)) === List(5, 5, 5))
  }
  
  test("sortF one element shold be itself") {
    
    assert(sortF(List(5)) === List(5))
  }
  
  test("sortF empty array shold be itself") {
    
    assert(sortF(List()) === List())
  }
  
}