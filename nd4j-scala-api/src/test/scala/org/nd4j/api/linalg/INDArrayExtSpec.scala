package org.nd4j.api.linalg

import org.junit.runner.RunWith
import org.nd4j.linalg.factory.Nd4j
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, FlatSpec}

import DSL._

@RunWith(classOf[JUnitRunner])
class INDArrayExtSpec extends FlatSpec with Matchers {

  "INDArrayExt" should "use the apply method to access values" in {

    // -- 2D array
    val nd2 = Nd4j.create(Array[Double](1, 2, 3, 4), Array(4, 1))

    nd2(0) === 1
    nd2(3, 0) === 4

    // -- 3D array
    val nd3 = Nd4j.create(Array[Double](1, 2, 3, 4, 5, 6, 7, 8), Array(2, 2, 2))
    nd3(0, 0, 0) === 1
    nd3(1, 1, 1) === 8

  }

  it should "use transpose abbreviation" in {
    val nd1 = Nd4j.create(Array[Double](1, 2, 3), Array(3, 1))
    nd1.shape should equal(Array(3, 1))
    val nd1t = nd1.t
    nd1t.shape should equal(Array(3))
  }

  it should "add correctly" in {
    val a = Nd4j.create(Array[Double](1, 2, 3, 4, 5, 6, 7, 8), Array(2, 2, 2))
    val b = a + 100
    a(0, 0, 0) === 1
    b(0, 0, 0) === 101
    a += 1
    a(0, 0, 0) === 2
  }

  it should "subtract correctly" in {
    val a = Nd4j.create(Array[Double](1, 2, 3, 4, 5, 6, 7, 8), Array(2, 2, 2))
    val b = a - 100
    a(0, 0, 0) === 1
    b(0, 0, 0) === -99
    a -= 1
    a(0, 0, 0) === 0

    val c = Nd4j.create(Array[Double](1 , 2))
    val d = c - c
    d(0) === 0
    d(1) === 0
  }

  it should "divide correctly" in {
    val a = Nd4j.create(Array[Double](1, 2, 3, 4, 5, 6, 7, 8), Array(2, 2, 2))
    val b = a / a
    a(1, 1, 1) === 8
    b(1, 1, 1) === 1
    a /= a
    a(1, 1, 1) === 1
  }

  it should "element-by-element multiply correctly" in {
    val a = Nd4j.create(Array[Double](1, 2, 3, 4), Array(4, 1))
    val b = a * a
    a(3) === 4  // [1.0, 2.0, 3.0, 4.0
    b(3) === 16 // [1.0 ,4.0 ,9.0 ,16.0]
    a *= 5 // [5.0 ,10.0 ,15.0 ,20.0]
    a(0) === 5
  }

  it should "use the update method to mutate values" in {
    val nd3 = Nd4j.create(Array[Double](1, 2, 3, 4, 5, 6, 7, 8), Array(2, 2, 2))
    nd3(0) = 11
    nd3(0) === 11

    val idx = Array(1, 1, 1)
    nd3(idx) = 100
    nd3(idx) === 100
  }

  it should "use === for equality comparisons" in {
    // NOTE === is also a scalatest operator. I'll note
    // the lines where our DSL operator is applied

    val a = Nd4j.create(Array[Double](1, 2))

    val b = Nd4j.create(Array[Double](1, 2))
    val c = a === b  // === from our DSL
    c(0) === 1
    c(1) === 1

    val d = Nd4j.create(Array[Double](10, 20))
    val e = a === d  // === from our DSL
    e(0) === 0
    e(1) === 0

    val f = a === 1  // === from our DSL
    f(0) === 1
    f(1) === 0
  }

  it should "use > for greater than comparisons" in {
    val a = Nd4j.create(Array[Double](1, 3))

    val b = a > 1
    b(0) === 0
    b(1) === 1

    val c = Nd4j.create(Array[Double](2, 2))
    val d = c > a
    d(0) === 0
    d(1) === 1
  }

  it should "use < for less than comparisons" in {
    val a = Nd4j.create(Array[Double](1, 3))

    val b = a < 2
    b(0) === 1
    b(1) === 0

    val c = Nd4j.create(Array[Double](2, 2))
    val d = c < a
    d(0) === 0
    d(1) === 1
  }

  it should "use - prefix for negation" in {
    val a = Nd4j.create(Array[Double](1, 3))
    val b = -a
    b(0) === -1
    b(1) === -3
  }

}