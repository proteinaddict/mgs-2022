import scala.math.abs
import scala.util.Random
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
  // TASK complete the code below by replacing all ??? occurances
  //    with correct code.

  type POLY = Map[Int,Double]

  val polyOne: POLY = Map(0 -> 1.0) // ???
  val polyZero: POLY = Map() // ???

  def polyAlmostEqual(p1:POLY, p2:POLY, epsilon:Double = .0001): Boolean = {
    val exponents= p1.keys.toSet.union(p2.keys.toSet)
    // must check <= epsilon, not < epsilon because epsilon might be == 0.0
    exponents.forall(n => abs(p1.getOrElse(n,0.0) - p2.getOrElse(n,0.0)) <= epsilon)
  }

  def polyAdd(p1:POLY, p2:POLY):POLY = {
    val exponents= p1.keys.toSet.union(p2.keys.toSet)
    (for { k <- exponents } yield k -> (p1.getOrElse(k,0.0) + p2.getOrElse(k,0.0))
      ).toMap
  }

  def polyScale(s:Double, p:POLY):POLY = {
    for {(k,v) <- p} yield k -> s*v
  }

  def polySubtract(p1:POLY, p2:POLY): POLY = {
    polyAdd(p1, polyScale(-1.0, p2))
  }

  def polyMultiply(p1:POLY, p2:POLY): POLY = {
    val polys = for { (k1,v1) <- p1}
      yield (for{(k2,v2) <- p2} yield (k1+k2)->(v1*v2))
    polys.fold(polyZero)(polyAdd)
  }

  def polyFastPower(p:POLY, n:Int): POLY = {
    assert(n >= 0)
    if (n == 0)
      polyOne
    else if (n == 1)
      p
    else if (n % 2 == 1) // odd
      polyMultiply(p, polyFastPower(p, n - 1))
    else { // even
      val q = polyFastPower(p, n / 2)
      polyMultiply(q, q)
    }
  }

  def polySlowPower(p:POLY, n:Int): POLY = {
    assert(n >= 0)
    if (n == 0)
      polyOne
    else if (n == 1)
      p
    else
      polyMultiply(p,polySlowPower(p,n-1))
  }

  def randomPoly(n:Int): POLY = {
    assert(n >= 0)
    val rand = new Random()
    val p = for{k <- 0 to n
                if rand.nextBoolean()
                coef = rand.between(-10.0,10.0)
                } yield k -> coef
    p.toMap
  }
}
