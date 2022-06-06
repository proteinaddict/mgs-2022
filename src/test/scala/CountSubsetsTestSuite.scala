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

import functions.CountSubsets._
import functions.Factorial._
import functions.FastPower._
import functions.Fibonacci._
import functions.QuadraticFormula._
import org.scalatest.funsuite.AnyFunSuite

import scala.math.abs

class CountSubsetsTestSuite extends AnyFunSuite {

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
}
