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
  // 1. TASK:
  //      Write a test to validate the following function.
  def quadraticFormula(a:Int, b:Int, c:Int):List[Double] = {
    List( (-b + sqrt(b*b - 4 * a * c)) / (2 * a),
          (-b - sqrt(b*b - 4 * a * c)) / (2 * a)).distinct
  }

  // 2. TASK:
  //    Update the formula to compute the discriminant,
  //    and detect whether there are zero, one, or two real roots.
  //    refactor the function to return a list of length 0, 1, or 2
  //    accordingly.  If there are two roots return them in increasing
  //    order.

  // 3. TASK:
  //    Do your tests still work?  If not, do you need to
  //    update your tests, or do you need to update the function?
  //    Make sure your tests are up to date, and that they test the
  //    new features you implemented in step #2.


  // 4. TASK:
  //     Implement two functions named power, one which accepts
  //      and Int base and Int exponent, and a second which accepts
  //      a Double base and Int exponent.  The second function should
  //      also support a negative exponent, however the first one cannot.
  //      Why can it not?
  //
  def power(b:Int, n:Int):Int = {
    ???
  }

  def power(b:Double, n:Int): Double = {
    ???
  }

  // 5. TASK:
  //      Implement String concatenation using the same model as the
  //      power function.  The function should accept a String, and an
  //      exponent n >= 0.  What should it return if n=0?
  def power(b:String, n:Int):String = {
    ???
  }

  // 6. TASK:
  //      Implement List concatenation using the same concept.  What
  //      should the function return when n=0?
  def power[T](b:List[T], n:Int):List[T] = {
    ???
  }

  // 7. TASK:
  //      Implement factorial as a recursive model.  What is the base
  //      case of the recursion?   Experimentally determine what happens
  //      if the input to the factorial function is large.  What is the
  //      largest Int for which you can correctly compute the factorial?
  def factorial(n:Int):Int = {
    ???
  }

  // 8. TASK:
  //      Use factorial to compute the number of n-sized subsets of an m-element set.
  //      Use your function to write some tests for the n-sized subset
  //      function which was developed in class.
  def countSubsets(n:Int, m:Int):Int = {
    ???
  }

  // 9. TASK
  //    Implement fibonacci.   Given n, compute the nth Fibonacci number.
  def fibonacci(n:Int):Int = {
    ???
  }

  def main(argv:Array[String]):Unit = {
    println("Hello this is main of SetsAndFunctions")
    println(quadraticFormula(1,2,-3))
    println(quadraticFormula(-1,3,7))
  }
}
