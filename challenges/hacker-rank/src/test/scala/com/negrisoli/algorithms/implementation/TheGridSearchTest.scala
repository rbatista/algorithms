package com.negrisoli.algorithms.implementation

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class TheGridSearchTest extends FunSuite with BeforeAndAfter {
  
  import com.negrisoli.algorithms.implementation.TheGridSearch._
  
  test("indexOfAll at middle") {
    assert(indexOffAll(Array(0, 1, 2, 3), Array(1,2)) === Array(1))
  }
  
  test("indexOfAll at begin") {
    assert(indexOffAll(Array(1, 2, 3), Array(1,2)) === Array(0))
  }
  
  test("indexOfAll at end") {
    assert(indexOffAll(Array(0, 1, 2), Array(1,2)) === Array(1))
  }
  
  test("indexOfAll not match") {
    assert(indexOffAll(Array(0, 1, 2, 3), Array(5,2)) === Array())
  }
  
  test("indexOfAll repeat begin") {
    assert(indexOffAll(Array(1, 1, 2, 3), Array(1,2)) === Array(1))
  }
  
  test("indexOfAll two matches") {
    assert(indexOffAll(Array(0, 1, 2, 1, 2, 5), Array(1,2)) === Array(1, 3))
  }
  
}