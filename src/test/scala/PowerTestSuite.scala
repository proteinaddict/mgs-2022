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

import functions.Power._
import org.scalatest.funsuite.AnyFunSuite

class PowerTestSuite extends AnyFunSuite {
  test("power Int") {
    assert(power(1, 12) == 1)
    assert(power(12, 0) == 1)
    assert(power(12, 2) == 144)
    assert(power(2, 8) == 256)
    assert(power(2,10) == 1024)
  }
  
  test("power Double") {
    assert(power(3.4, 0) == 1.0)
    assert(power(3.4, 1) == 3.4)
    assert(power(3.4, 2) == 3.4 * 3.4)
    assert(power(13.0, 0) == 1.0)
    assert(power(4.0, 3) == 4.0 * 4.0 * 4.0)
  }

  test("power String") {
    assert(power("x", 0) == "")
    assert(power("x", 1) == "x")
    assert(power("x", 3) == "xxx")
  }

  test("power List") {
    assert(power(List(1, 2), 0) == List())
    assert(power(List(1, 2), 3) == List(1, 2, 1, 2, 1, 2))
  }
}
