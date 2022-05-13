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
import functions.Fibonacci._
import functions.QuadraticFormula._
import functions.FastPower._
import functions.Factorial._
import functions.CountSubsets._
import scala.math.abs

class SetsAndFunctionsTestSuite extends AnyFunSuite {

  test("quadraticFormula") {
    assert(quadraticFormula(1, 0, 0) == List(0.0))
    assert(
      quadraticFormula(1, 2, 3).size == 2
    ) // assert that there are two roots
    println(quadraticFormula(1, 1, 1))
  }

  test("quadraticFormula check roots") {
    // in class we develop a property based test
    // to check the quadraticFormula function
    val epsilon = 0.001

    def check(r1: Double, r2: Double, a: Double, b: Double, c: Double): Unit = {
      def p1(x: Double): Double = {
        (x - r1) * (x - r2)
      }

      def p2(x: Double): Double = {
        a * x * x + b * x + c
      }

      for {i <- -100 to 100
           x = i.toDouble / 13} {
        assert(abs(p1(x) - p2(x)) < epsilon,
               s"wrong roots for a=$a b=$b c=$c, with x=$x  p1(x)=${p1(x)} p2(x)=${p2(x)}")
      }
    }

    for {a <- (-10 to 10)
         if a != 0
         b <- (-10 to 10)
         c <- (-10 to 10)
         roots = quadraticFormula(a, b, c)
         } {
      roots match {
        case List() => ()
        case List(r1, r2) => check(r1, r2, a, b, c)
        case List(r) => check(r, r, a, b, c)
      }
    }
  }

  test("power") {
    assert(power(3, "x") == "xxx")
    assert(power(3, List(1, 2)) == List(1, 2, 1, 2, 1, 2))
    assert(power(3, 4.0) == 4.0 * 4.0 * 4.0)

    assert(power(0, "x") == "")
    assert(power(0, 13.0) == 1.0)
    assert(power(0, List(1, 2)) == List())
  }

  test("factorial") {
    assert(factorial(0) == 1)
    assert(factorial(1) == 1)
    assert(factorial(3) == 6)
    assert(factorial(7) == 7 * factorial(6))
  }

  test("fixedSizeSubsets") {
    assert(fixedSizedSubsets(0, Set(1, 2, 3)) == Set(Set()))
    assert(fixedSizedSubsets(1, Set(1, 2, 3)) == Set(Set(1), Set(2), Set(3)))
    assert(
      fixedSizedSubsets(2, Set(1, 2, 3)) == Set(Set(1, 2), Set(1, 3), Set(2, 3))
      )
    assert(fixedSizedSubsets(3, Set(1, 2, 3)) == Set(Set(1, 2, 3)))
    assert(
      fixedSizedSubsets(3, Set(1, 2, 3, 4)) == Set(
        Set(1, 2, 3),
        Set(1, 2, 4),
        Set(1, 3, 4),
        Set(2, 3, 4)
        )
      )
    // how many subsets of size n of a set of size 5?  = C(5,n) = 5!/(n!(5-n)!)
    assert(
      5 * 4 * 3 * 2 / (1 * (5 * 4 * 3 * 2)) == fixedSizedSubsets(
        0,
        Set(1, 2, 3, 4, 5)
        ).size
      )
    assert(
      5 * 4 * 3 * 2 / (1 * (4 * 3 * 2)) == fixedSizedSubsets(
        1,
        Set(1, 2, 3, 4, 5)
        ).size
      )
    assert(
      5 * 4 * 3 * 2 / (2 * (3 * 2)) == fixedSizedSubsets(
        2,
        Set(1, 2, 3, 4, 5)
        ).size
      )
    assert(
      5 * 4 * 3 * 2 / (3 * 2 * 2) == fixedSizedSubsets(
        3,
        Set(1, 2, 3, 4, 5)
        ).size
      )
    assert(
      5 * 4 * 3 * 2 / (4 * 3 * 2 * 1) == fixedSizedSubsets(
        4,
        Set(1, 2, 3, 4, 5)
        ).size
      )
    assert(
      5 * 4 * 3 * 2 / (4 * 4 * 3 * 2 * 1) == fixedSizedSubsets(
        5,
        Set(1, 2, 3, 4, 5)
        ).size
      )
  }

  test("fixedSizedSubsets"){
    for {
      k <- 0 to 6
      subsets = fixedSizedSubsets(k, Set(1, 2, 3, 4, 5, 6))
    } assert(subsets.size == countFixedSizedSubsets(6,k))
  }

  test("fibonacci") {
    assert(fibonacci(0) == 1)
    assert(fibonacci(1) == 1)
    assert(fibonacci(2) == 2)
    assert(fibonacci(3) == 3)
    assert(fibonacci(4) == 5)
    assert(fibonacci(5) == 8)
    assert(fibonacci(6) == 13)
  }
}
