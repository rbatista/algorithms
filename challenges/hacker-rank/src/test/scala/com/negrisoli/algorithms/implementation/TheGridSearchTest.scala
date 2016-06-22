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
  
  
  trait MatrixTest {
    val mat0: Matrix = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
    val pat0: Matrix = Array(Array(1, 2), Array(4, 5))
    val pat0_0: Matrix = Array(Array(0, 1), Array(4, 5))
    val pat0_1: Matrix = Array(Array(4, 5), Array(7, 8))
    val mat1: Matrix = Array(Array(9, 9, 9), Array(1, 2, 3), Array(5, 5, 5))
    val pat1: Matrix = Array(Array(9, 9), Array(1, 2), Array(5, 5))
    
    val mat2: Matrix = Array(Array(1, 2, 3, 4, 1, 2), Array(5, 6, 1, 2, 1, 2),
        Array(1, 2, 3, 6, 3, 4), Array(7, 8, 1, 2, 8, 8))
    val pat2: Matrix = Array(Array(1, 2), Array(3, 4))
    
  }
  
  test("matchPattern find mat0") {
    new MatrixTest {
      assert(matchPattern(mat0, pat0) == true)
    }
  }
  
  test("matchPattern find mat1") {
    new MatrixTest {
      assert(matchPattern(mat1, pat1) == true)
    }
  }
  
  test("matchPattern not find mat0") {
    new MatrixTest {
      assert(matchPattern(mat0, pat1) == false)
    }
  }
  
  test("matchPattern not match mat0 deslocated pattern 0_0") {
    new MatrixTest {
      assert(matchPattern(mat0, pat0_0) == false)
    }
  }
  
  test("matchPattern match mat0 on second line") {
    new MatrixTest {
      assert(matchPattern(mat0, pat0_1) == true)
    }
  }
  
  test("matchPattern match mat2") {
    new MatrixTest {
      assert(matchPattern(mat2, pat2) == true)
    }
  }
}