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

object PolynomialRing {
  type POLY = Map[Int,Double]

  def polyAlmostEqual(p1:POLY, p2:POLY, epsilon:Double = .0001): Boolean = {
    ???
  }

  def polyAdd(p1:POLY, p2:POLY):POLY = {
    ???
  }

  def polyScale(s:Double, p1:POLY):POLY = {
    ???
  }

  def polySubtract(p1:POLY, p2:POLY): POLY = {
    polyAdd(p1, polyScale(-1.0, p2))
  }

  def polyMultiply(p1:POLY, P2:POLY): POLY = {
    ???
  }

  def polyFastPower(p1:POLY, n:Int): POLY = {
    assert(n >= 0)
    ???
  }

  def polySlowPower(p1:POLY, n:Int): POLY = {
    assert(n >= 0)
    ???
  }

  def randomPoly(n:Int): POLY = {
    assert(n >= 0)
    ???
  }
}
