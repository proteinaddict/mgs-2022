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

class FactorialTestSuite extends AnyFunSuite {
  test("factorial") {
    assert(factorial(1) == 1)
    assert(factorial(3) == 6)
    assert(factorial(7) == 7 * factorial(6))
  }

  test("factorial base"){
    assert(factorial(0) == 1)
  }

  test("factorials 15"){
    for{n <- 1 to 15
        }
      assert(factorial(n) == factorial(n-1) * n)
  }
}