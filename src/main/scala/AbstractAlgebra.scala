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

object AbstractAlgebra {
  // TASK: take a sequence of strings and return the equivalence
  //   classes, (as a Map[Int,String]) by length.  I.e., each
  //   equivalence class should contains strings of the same length,
  //   and there should be one equivalence class for each positive
  //   length.  Omitting equivalence classes of size 0.
  def groupByStringSize(strs: Seq[String]): Map[Int, Seq[String]] = {
    ???
  }

  // TASK: given a sequence of sets of integers, partition them by
  //   minimum element
  def groupByMinElement(sets: Seq[Set[Int]]): Map[Int, Seq[Set[Int]]] = {
    ???
  }

  // TASK: given the lower and upper bounds (inclusive) of a sequence
  //   of integers, and an integer n,
  //   partition the integers into equivalence classes modulo-n
  def groupByModulus(lower: Int, upper: Int, n: Int): Map[Int, Seq[Int]] = {
    ???
  }

  // TASK: matrix add
  def matrixAdd(m: Vector[Vector[Int]], n: Vector[Vector[Int]]): Vector[Vector[Int]] = {
    ???
  }

  def matrixScale(s: Int, m: Vector[Vector[Int]]): Vector[Vector[Int]] = {
    ???
  }
  // TASK: matrix subtract in terms of matrixScale
  def matrixSubtract(m: Vector[Vector[Int]], n: Vector[Vector[Int]]): Vector[Vector[Int]] = {
    matrixAdd(m, matrixScale(-1, n))
  }

  // TASK: matrix multiply
  def matrixMultiply(m: Vector[Vector[Int]], n: Vector[Vector[Int]]): Vector[Vector[Int]] = {
    ???
  }

  // TASK: power of matrix, use the fast monoid multiplication
  def matrixPower(m: Vector[Vector[Int]], n:Int): Unit ={
    assert(n >=0)
    ???
  }

  // TASK: add two complex numbers by using MatrixAdd
  def complexAdd(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    ???
  }

  // TASK: subtract subtract two complex numbers by using matrixSubtract
  def complexSubtract(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    ???
  }

  // TASK: multiply two complex numbers by using matrixMultiply
  def complexMultiply(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    ???
  }

  // TASK: generate a random n x n matrix.  i.e. an nxn matrix
  //   with random integers.   Limit the integers to -100 <= k <= 100
  def randomMatrix(n: Int): Vector[Vector[Int]] = {
    assert(n > 0) // only consider matrices of positive size
    ???
  }
}
