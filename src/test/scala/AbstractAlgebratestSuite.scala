// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge,
// publish, distribute, sublicense, and/or sell copies of the Software,
// and to permit persons to whom the Software is furnished to do so,
// subject to the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class AbstractAlgebraTestSuite extends AnyFunSuite {

  import algebra.Matrix._
  import algebra.Complex._

  test("matrixAdd") {
    assert(matrixAdd(Vector(Vector(1, 2, 3),
                            Vector(-1, 2, 0),
                            Vector(2, 1, 1)),
                     Vector(Vector(2, 0, 1),
                            Vector(-3, 1, 1),
                            Vector(0, -1, 0))) == Vector(Vector(3, 2, 4),
                                                         Vector(-4, 3, 1),
                                                         Vector(2, 0, 1)))
  }

  test("matrixSubtract") {
    assert(matrixSubtract(Vector(Vector(1, 2, 3),
                                 Vector(-1, 2, 0),
                                 Vector(2, 1, 1)),
                          Vector(Vector(2, 0, 1),
                                 Vector(-3, 1, 1),
                                 Vector(0, -1, 0))) == Vector(Vector(-1, 2, 2),
                                                              Vector(2, 1, -1),
                                                              Vector(2, 2, 1)))
  }

  test("matrixMultiply") {
    assert(matrixMultiply(Vector(Vector(1, 2, 3),
                                 Vector(-1, 2, 0),
                                 Vector(2, 1, 1)),
                          Vector(Vector(2, 0, 1),
                                 Vector(-3, 1, 1),
                                 Vector(0, -1, 0))) == Vector(Vector(-4, -1, 3),
                                                              Vector(-8, 2, 1),
                                                              Vector(1, 0, 3)))
  }

  test("matrixPower") {

  }

  test("complexAdd") {
    assert((4, 7) == complexAdd((1, 2), (3, 5)))
  }

  test("complexSubtract") {
    assert((-2, -3) == complexSubtract((1, 2), (3, 5)))
  }

  test("complexMultiply") {
    assert((-5, 10) == complexMultiply((1, 2), (3, 4)))
  }

  test("i*i = -1") {
    assert((-1, 0) == complexMultiply((0, 1), (0, 1)))

    // ??? // how can you test that i*i == -1
  }

  test("matrix addition commutative") {
    for {n <- 1 to 5
         _ <- 0 to 1000
         a = matrixRandom(n)
         b = matrixRandom(n)
         } assert(matrixAdd(a, b) == matrixAdd(b, a))
  }

  test("matrix addition associative") {
    for {n <- 1 to 5
         _ <- 0 to 1000
         a = matrixRandom(n)
         b = matrixRandom(n)
         c = matrixRandom(n)
         } assert(matrixAdd(a, matrixAdd(b, c)) == matrixAdd(matrixAdd(a, b), c))
  }

  test("matrix multiplication associative") {
    for {n <- 1 to 5
         _ <- 0 to 1000
         a = matrixRandom(n)
         b = matrixRandom(n)
         c = matrixRandom(n)
         } assert(matrixMultiply(a, matrixMultiply(b, c)) == matrixMultiply(matrixMultiply(a, b), c))
  }

  test("complex multiplication commutative") {
    val rand = new Random()
    for {_ <- 0 to 1000
         a = (rand.between(-10, 10).toDouble, rand.between(-10, 10).toDouble)
         b = (rand.between(-10, 10).toDouble, rand.between(-10, 10).toDouble)
         } assert(complexMultiply(a, b) == complexMultiply(b, a))
  }
}
