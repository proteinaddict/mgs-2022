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

import math.sqrt

object SetsAndFunctions {
  // 1. TASK: Write a test to validate the following function.
  // 2. TASK: Update the formula to compute the discriminant,
  //    and detect whether there are zero, one, or two real roots.
  //    refactor the function to return a list of length 0, 1, or 2
  //    accordingly.  If there are two roots return them in increasing
  //    order.
  def quadraticFormula(a: Int, b: Int, c: Int): List[Double] = {
    List((-b + sqrt(b * b - 4 * a * c)) / (2 * a),
         (-b - sqrt(b * b - 4 * a * c)) / (2 * a)).distinct
  }

  // Recursive functions
  // 3. TASK: implement power to return x^n where x in an Int
  def power(n: Int, x: Int): Int = {
    ???
  }

  // 4. TASK: implement power to return x^n where x in an Double.
  //   In the case of Double (not not the other cases), you may
  //   also implement negative exponents.  What to do if n<0.
  def power(n: Int, x: Double): Double = {
    //???
    if (n == 0)
      1.0
    else
      power(n-1,x) * x
  }

  // 5. TASK: implement power to return x^n where x in a String
  //     note that x^0 = ""
  //     you may append lists with +. e.g., "abc" + "xyz" gives "abcxyz"
  def power(n: Int, x: String): String = {
    if (n == 0)
      ""
    else
      power(n-1,x) + x
  }

  // 6. TASK: implement power to return x^n where x in a List[T]
  //    x^0 = List()
  //    you may append lists with ++
  def power[T](n: Int, x: List[T]): List[T] = {
    if (n == 0)
      List()
    else
      power(n-1,x) ++ x
  }

  // 7. TASK: implement factorial
  def factorial(n: Int): Int = {
    assert(n >= 0, s"n must be non-negative, got n=$n")
    //???
    if (n == 0)
      1
    else
      n * factorial(n-1)
  }

  // 8. TASK: you can now test this function, as factorial
  //    has been implemented.
  def fixedSizedSubsets[T](n: Int, s: Set[T]): Set[Set[T]] = {
    assert(n >= 0, s"n must be non-negative, got n=$n")
    if (n == 0)
      Set(Set())
    else if (n == 1) {
      for {e <- s
           } yield Set(e)
    } else { // n > 1
      for {e <- s
           subs = fixedSizedSubsets(n - 1, s - e)
           sub <- subs
           } yield sub + e
    }
  }

  // 9. TASK:  compute the n'th fibonacci number. (zero indexed)
  def fibonacci(n: Int): Int = {
    if (n == 0)
      1
    else if (n == 1)
      1
    else
      fibonacci(n-1) + fibonacci(n-2)
  }

  // 10. TASK: Given two sets, compute the union
  def setUnion[T](a:List[T],b:List[T]):List[T] = {
    //???
    a ++ b.filter(x => ! a.contains(x))
  }

  // 11. TASK: Given two sets, compute the intersection
  def setIntersection[T](a:List[T],b:List[T]):List[T] = {
    a.filter{x => b.contains(x)}
  }

  // 12. TASK: Given two sets, compute the relative complement
  def setMinus[T](a:List[T],b:List[T]):List[T] = {
    a.filter(x => ! b.contains(x))
  }

  // 13. TASK: set equivalence
  def setEqual[T](a:List[T],b:List[T]):Boolean = {
    a.forall(x => b.contains(x)) &&
      b.forall(x => a.contains(x))
  }

  def main(argv: Array[String]): Unit = {
    println("Hello this is main of SetsAndFunctions")
  }
}
