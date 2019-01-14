package com.negrisoli.algorithms.implementation

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class TheGridSearchTest extends FunSuite with BeforeAndAfter {
  
  import com.negrisoli.algorithms.implementation.TheGridSearch._
  
  test("indexOfAll at middle") {
    assert(indexOffAll("0123", "12") === List(1))
  }
  
  test("indexOfAll at begin") {
    assert(indexOffAll("123", "12") === List(0))
  }
  
  test("indexOfAll at end") {
    assert(indexOffAll("012", "12") === List(1))
  }
  
  test("indexOfAll not match") {
    assert(indexOffAll("0123", "52") === List())
  }
  
  test("indexOfAll repeat begin") {
    assert(indexOffAll("1123", "12") === List(1))
  }
  
  test("indexOfAll two matches") {
    assert(indexOffAll("012125", "12") === List(1, 3))
  }
  
  
  trait MatrixTest {
    val mat0: Matrix = List("012", "345", "678")
    val pat0: Matrix = List("12", "45")
    val pat0_0: Matrix = List("01", "45")
    val pat0_1: Matrix = List("45", "78")
    val mat1: Matrix = List("999", "123", "555")
    val pat1: Matrix = List("99", "12", "55")
    
    val mat2: Matrix = List("123412", "561212",
        "123634", "781288")
    val pat2: Matrix = List("12", "34")
    
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