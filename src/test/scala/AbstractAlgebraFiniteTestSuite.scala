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

class AbstractAlgebraFiniteTestSuite extends AnyFunSuite {

  import algebra.AbstractAlgebraFinite._

  def cartesianProduct[T](s:Set[T],mult:(T,T)=>T):(Set[(T,T)],((T,T),(T,T))=>(T,T)) = {
    val newSet = for{ x <- s
         y <- s } yield (x,y)
    def newMult(a:(T,T),b:(T,T)):(T,T) = {
      val (a1,a2) = a
      val (b1,b2) = b
      (mult(a1,b1),mult(a2,b2))
    }
    (newSet,newMult)
  }

  val rotationGroup = {
    def mult(a: String, b: String): String = {
      (a, b) match {
        case ("R0", b) => b
        case (_, "R0") => a

        case ("MY", "MYR90") => "R90"
        case ("MY", "MXR90") => "R270"
        case ("MY", "MX") => "R180"
        case ("MY", "MY") => "R0"
        case ("MY", "R270") => "MXR90"
        case ("MY", "R180") => "MX"
        case ("MY", "R90") => "MYR90"

        case ("R90", "R90") => "R180"
        case ("R90", "R180") => "R270"
        case ("R90", "R270") => "R0"
        case ("R90", "MX") => "MYR90"
        case ("R90", "MY") => "MXR90"
        case ("R90", "MXR90") => "MX"
        case ("R90", "MYR90") => "MY"

        case ("R180", "R90") => "R270"
        case ("R180", "R180") => "R0"
        case ("R180", "R270") => "R90"
        case ("R180", "MX") => "MY"
        case ("R180", "MY") => "MX"
        case ("R180", "MXR90") => "MYR90"
        case ("R180", "MYR90") => "MXR90"

        case ("R270", "R90") => "R0"
        case ("R270", "R180") => "R90"
        case ("R270", "R270") => "R180"
        case ("R270", "MX") => "MXR90"
        case ("R270", "MY") => "MYR90"
        case ("R270", "MXR90") => "MY"
        case ("R270", "MYR90") => "MX"

        case ("MX", "R90") => "MXR90"
        case ("MX", "R180") => "MY"
        case ("MX", "R270") => "MYR90"
        case ("MX", "MX") => "R0"
        case ("MX", "MY") => "R180"
        case ("MX", "MXR90") => "R90"
        case ("MX", "MYR90") => "R270"

        case ("MY", "R90") => "MYR90"
        case ("MY", "R180") => "MX"
        case ("MY", "R270") => "MXR90"
        case ("MY", "MX") => "R180"
        case ("MY", "MY") => "R0"
        case ("MY", "MXR90") => "R270"
        case ("MY", "MYR90") => "R90"

        case ("MXR90", "R90") => "MY"
        case ("MXR90", "R180") => "MYR90"
        case ("MXR90", "R270") => "MX"
        case ("MXR90", "MX") => "R270"
        case ("MXR90", "MY") => "R90"
        case ("MXR90", "MXR90") => "R0"
        case ("MXR90", "MYR90") => "R180"

        case ("MYR90", "R90") => "MX"
        case ("MYR90", "R180") => "MXR90"
        case ("MYR90", "R270") => "MY"
        case ("MYR90", "MX") => "R90"
        case ("MYR90", "MY") => "R270"
        case ("MYR90", "MXR90") => "R180"
        case ("MYR90", "MYR90") => "R0"

        case _ => ???
      }
    }

    val rotations = Set("R0", "R90", "R180", "R270",
                        "MX", "MY", "MXR90", "MYR90")
    (rotations, mult _)
  }

  val kleinGroup = (Set(1, 2, 3, 4), {
    def add(a: Int, b: Int): Int = {
      if (a == 1)
        b
      else if (b == 1)
        a
      else if (a == b)
        1
      else
        (Set(2, 3, 4) - a - b).head
    }

    add _
  })

  def zMod(k: Int): (Set[Int], (Int, Int) => Int, (Int, Int) => Int) = {
    ((0 until k).toSet,
      (a: Int, b: Int) => (a + b) % k,
      (a: Int, b: Int) => (a * b) % k)
  }

  test("monoid") {
    assert(isMonoid(kleinGroup._1, kleinGroup._2))
    assert(isMonoid(rotationGroup._1, rotationGroup._2))
    for {k <- 1 to 7
         triple = zMod(k)} {
      assert(isMonoid(triple._1, triple._2))
      assert(isMonoid(triple._1, triple._3))
    }
    for {n <- 3 to 10} {
      val s = (0 until n).toSet

      def subtract(a: Int, b: Int): Int = {
        (a - b + n) % n
      }

      assert(!isMonoid(s, subtract), s"should not be a monoid for n=$n s=$s")
    }
    val kleinX2 = cartesianProduct(kleinGroup._1,kleinGroup._2)
    assert(isMonoid(kleinX2._1, kleinX2._2))
    val rotationX2 = cartesianProduct(kleinX2._1,kleinX2._2)
    assert(isMonoid(rotationX2._1, rotationX2._2))
  }

  test("group") {
    assert(Some(1) == findIdentity(kleinGroup._1, kleinGroup._2))
    assert(isGroup(kleinGroup._1, kleinGroup._2))
    assert(Some("R0") == findIdentity(rotationGroup._1, rotationGroup._2))
    assert(isGroup(rotationGroup._1, rotationGroup._2))
  }

  test("abelian") {
    assert(isAbelian(kleinGroup._1, kleinGroup._2))
    assert(!isAbelian(rotationGroup._1, rotationGroup._2))
  }

  test("ring") {
    for {k <- 2 to 7
         triple = zMod(k)} {
      assert(isRing(triple._1, triple._2, triple._3),
             s"should be a ring if k=$k, triple=${triple._1}")
    }
  }

  test("field") {
    for {k <- 2 to 9
         (s, add, times) = zMod(k)} {
      if (Seq(2, 3, 5, 7).contains(k)) { //primes
        assert(isField(s, add, times),
               s"should be a field if k is prime, k=$k, s=$s")
      } else // composite not a field
        assert(!isField(s, add, times),
               s"should not be a field if k is composite, k=$k")
    }
    assert(!isField(rotationGroup._1, rotationGroup._2, rotationGroup._2))
  }
}
