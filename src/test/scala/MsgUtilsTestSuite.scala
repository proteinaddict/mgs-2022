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

import MgsUtils.makeCounter
import org.scalatest.funsuite.AnyFunSuite

class MsgUtilsTestSuite extends AnyFunSuite {
  test("test1") {
    val c1 = makeCounter()
    val c2 = makeCounter(incr=3)
    val c3 = makeCounter(start=10, incr = -1)
    assert(c1() == 1, "problem with 1st call to c1")
    assert(c3() == 9, "problem with 1st call to c3")
    assert(c1() == 2, "problem with 2nd call to c1")
    assert(c2() == 3, "problem with 1st call to c2")
    assert(c2() == 6, "problem with 4th call to c2")
    assert(c1() == 3, "problem with 3rd call to c1")
    assert(c2() == 9, "problem with 2nd call to c2")
    assert(c3() == 8, "problem with 2nd call to c3")
  }
}
